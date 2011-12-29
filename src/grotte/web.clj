(ns grotte.web
  (:use compojure.core
	ring.util.response
	hiccup.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
	    [ring.adapter.jetty :as jetty]
	    [grotte.data :as data]))

(defn do-page
  []
  (html [:head
	 [:title "The title"]
         
         ;; JQuery and CSS stuff.
         [:link {:src "http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
                 :rel "stylesheet" :type "text/css"}]
         [:script {:src "http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"}]
         [:script {:src "http://ajax.googleapis.com/ajax/libs/jquery-ui/1.8/jquery-ui.min.js"}]
	 [:script {:type "text/javascript" :src "conjure.js"}]
         
         ;; Our own lightweight styling.
         [:style {:type "text/css"}
          (str "h1, h2, h3 { font-family: \"Gill Sans\", Optima, sans-serif; }"
               "#li { margin-top: 0.2em; margin-bottom: 0.4em; }")]]
        
	[:body
	 [:h1 "grotte: rails without restarting"]
	 [:p "Sketch out a schema with sample data (someday) right in the browser."]
         
	 [:p "Upload some data to see how your schema feels. Create "
          "tables, add and drop columns, define foreign keys, add and "
          "delete rows, edit values in place, and browse your data.  All "
          "instantly, right in the browser.  Convert your app (and its "
          "data) to Rails, Django, or Grails; or just host your app here, someday."]
         
         ;; List of defined entity types.
         [:h3 "Domains"]
         [:p "If you're coming from SQL land, a domain is a table."]
         (for [[domain visible] (sort @data/*domains*)]
	   (if visible [:p [:a {:href (str "/" (name domain))} (str domain)]]))]))

(defn now
  []
  (html [:em (System/currentTimeMillis)]))

(defn render-cell
  "Assumes row is a map one of whose keys is column.
  Renders (get @row column) by default, but may do more interesting
  things depending on the value of (:type column)."
  [domain row column]
  (let [coltype (get @(data/*coltypes* domain) column)]
    (case coltype

      ;; Plain old text values.  Requires javascript glue elsewhere (domain-table).
      :editable-text
      [:div
       [:span    {:id (str "EDIT-" (:id @row) "_" (subs (str column) 1))} (get @row column)]
       [:script {:type "text/javascript"}
        (str "$(\"#EDIT-" (:id @row) "_" (subs (str column) 1) "\").editable('/"
             (subs (str domain) 1) "/edit/EDIT-" (:id @row) "_" (subs (str column) 1) "',"
             "{tooltip: \"Click to edit...\", style : \"inherit\", loadtype:'POST', id:'" (:id row) "',domain:'" (subs (str domain) 1) "'});")]]

      ;; Dates.  Picked by typing MM/DD/YYYY or with JQuery UI calendar widget.  Stored as MM/DD/YYYY strings.
      ;; Requires javascript glue elsewhere (domain-table).
      :date
      [:div
       [:span {:class "dt" :id (str "DATE-" (:id @row) "_" (subs (str column) 1))} (get @row column)]
       [:script {:type "text/javascript"}
        (str "$(\"#DATE-" (:id @row) "_" (subs (str column) 1) "\").editable('/"
             (subs (str domain) 1) "/edit/DATE-" (:id @row) "_" (subs (str column) 1) "',"
             "{tooltip: \"Click to edit...\", style : \"inherit\", type: \"datepicker\"});")]]

      ;; Foreign key relation to the :item domain.  Assumes :item as defined in grotte.core.
      :item (if (nil? (get @row column))
              [:i "nil"]
              [:a {:href (str "/item/show/" (:id @(get @row column)))} (str "Item #" (:id @(get @row column)))])

      ;; Default to read-only text.
      (get @row column)

      )))


(defn domain-table
  "Renders an HTML table with all the rows for this domain.  It
  delegates to render-cell to figure out exactly how each cell should
  be rendered.  Of course, There's no sorting or filtering yet."

  [domain]
  [:div
   [:table {:border "1" :cellspacing "0"}
    [:tr (for [k (concat [:id :id] @(get @data/*columns* domain))]
	   [:th (str k) [:a {:href (str "/" (subs (str domain) 1) "/drop-column/" (subs (str k) 1))} "x"]])]
    (for [row @(get @data/*rows* domain)]
      [:tr {:id (:id @row)}
       [:td [:a {:href "#" :id (str "DEL-" (:id @row))} "delete"]]
       [:td [:a {:href (str "/" (subs (str domain) 1) "/show/" (:id @row))} "show"]]
       (for [k @(get @data/*columns* domain)]
	 [:td (render-cell domain row k)])]
      )
    [:tr [:td {:colspan (+ 2 (count @(get @data/*columns* domain)))}
          [:a {:href (str "/" (name domain) "/create")} "Create row"]]]]

   ;; Now Javascript wiring...
   (for [row @(get @data/*rows* domain)]
     ;; ...for the delete action.
     [:script {:type "text/javascript"} (str "ajaxClick(\"#DEL-" (:id @row) "\","
                                             "{type: \"GET\", "
                                             " url: \"/" (subs (str domain) 1) "/delete/" (:id @row) "\","
                                             " dataType: \"html\", success: ajaxRemove(\"#" (:id @row) "\"),"
                                             " error: ajaxError, confirm: null})")])
   ])


(defn domain-page
  [domain]
  (html [:head
	 [:title (str domain "s")]
         [:link {:href "http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
                 :rel "stylesheet" :type "text/css"}]
	 [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"}]
	 [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"}]
	 [:script {:type "text/javascript" :src "jquery.jeditable.js"}]
	 [:script {:type "text/javascript" :src "jquery.jeditable.datepicker.js"}]
	 [:script {:type "text/javascript" :src "conjure.js"}]
	 [:style {:type "text/css"}
          (str "h1, h2, h3 { font-family: \"Gill Sans\", Optima, sans-serif; }"
               " #li { margin-top: 0.2em; margin-bottom: 0.4em; }")]
	[:body
	 [:p [:a {:href "/"} "Home"] " &#8212; " [:b (str domain "s")]]
	 [:h1 (str domain "s")]
	 (domain-table domain)]]))

(defn ref? [x]
  (and (not (nil? x)) (= "class clojure.lang.Ref" (str (class x)))))

(defn row-page
  [domain id]
  (html [:head
	 [:title (str domain "s")]
         [:link {:href "http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css"
                 :rel "stylesheet" :type "text/css"}]
	 [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"}]
	 [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"}]
	 [:script {:type "text/javascript" :src "jquery.jeditable.js"}]
	 [:script {:type "text/javascript" :src "jquery.jeditable.datepicker.js"}]
	 [:script {:type "text/javascript" :src "conjure.js"}]
	 [:style {:type "text/css"}
          (str
           "h1, h2, h3 { font-family: \"Gill Sans\", Optima, sans-serif; }"
           " #li { margin-top: 0.2em; margin-bottom: 0.4em; }")]]
	[:body
	 [:p {:id "breadcrumbs"}
          [:a {:href "/"} "Home"]
          " &#8212; "
          [:a {:href (str "/" (subs (str domain) 1))} (str domain "s")]
          " &#8212; "
          [:b (subs (str domain) 1) " " id]]

	 (let [current-row (first (filter #(= (str (:id (deref %))) id) @(get @data/*rows* domain)))]
	   (let [x
		 (loop [row (if (ref? current-row) @current-row current-row) i 0 acc [:ul]]
		   (if (nil? row) acc
		       (recur (:parent row) (dec i)
			      (conj acc
				    [:li i]
				    [:ul
				     [:li (str domain " " id)]
				     [:li (get row (nth (keys row) 1))]]))))]
	     x))
	 [:hr]]))

(def jquery-jeditable (slurp "src/js/jquery.jeditable.js"))
(def jquery-jeditable-datepicker (slurp "src/js/jquery.jeditable.datepicker.js"))
(def conjure-js (slurp "src/js/conjure.js"))

(defroutes the-routes
  (GET "/" []
       (do-page))

  (GET "/now" []
       (now))
  (GET "*conjure.js" []
       conjure-js)
  (GET "*jquery.jeditable.js" []
       jquery-jeditable)
  (GET "*jquery.jeditable.datepicker.js" []
       jquery-jeditable-datepicker)

  (GET "/:domain" [domain]
       (domain-page (keyword domain)))
  (GET "/:domain/show/:id" [domain id]
       (row-page (keyword domain) id))
  (GET "/:domain/delete/:id" [domain id]
       (data/delete-row-by-idstring (keyword domain) id))
  (GET "/:domain/drop-column/:column-name" [domain column-name]
    (data/drop-column (keyword domain) (keyword column-name))
    (redirect (str "/" domain)))
  (GET "/:domain/create" [domain]
       (data/make-row (keyword domain))
       (redirect (str "/" domain)))

  (POST "/:domain/edit/:id" {params :params} []
        (do
          (prn params)
          (let [column-name (subs (params :id) 42)
                value (params :value)
                domain (params :domain)
                real-id (subs (params :id) 5 41)]  ;; 5 is just (count "EDIT-")
            (data/update-row-by-idstring (keyword domain) real-id (keyword column-name) value)
            value)))

  (route/not-found "404: Fail whale"))


(def app (handler/api (var the-routes)))

(defonce server (ref nil))
(defn start-server
  []
  (ref-set server (jetty/run-jetty app {:port 4000 :join? false})))
(defn stop-server
  []
  (.stop @server))

