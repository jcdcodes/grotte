(ns grotte.web
  (:use compojure.core
	ring.util.response
	hiccup.core
        hiccup.form)
  (:require [compojure.route]
            [compojure.handler]
            [clojure.data.json :as json]
	    [ring.adapter.jetty :as jetty]
	    [grotte.data :as data]
            [grotte.prevail :as prevail]))

(defn- local-css
  []
  (str "h1, h2, h3 { font-family: \"Gill Sans\", Optima, sans-serif; } "
       "#li { margin-top: 0.2em; margin-bottom: 0.4em; } "
       "body { font-family: 'Helvetica Neue', 'Gill Sans', Optima, sans-serif; } "))

(defn root-page
  []
  (html [:head
	 [:title "The title"]
         
         ;; JQuery and CSS stuff.
         [:script {:src "jquery.min.js"}]
         [:script {:type "text/javascript" :src "conjure.js"}]
         
         ;; Our own lightweight styling.
         [:style {:type "text/css"} (local-css)]]
        
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
	   (if visible [:p [:a {:href (str "/" (name domain))} (str domain)] " (" (count (filter #(not (:deleted @%)) @(get @data/*rows* domain))) ")"]))
         [:div {:id "new-domain-div"}
          (form-to [:post (str "/create-domain" )]
                   (text-field "domain")
                   (submit-button "Create New Domain"))]]))

(defn now
  []
  (html [:em (System/currentTimeMillis)]))

(defn render-cell
  [domain row column]
  (let [coltype (get @(data/*coltypes* domain) column)]
    (case coltype

      ;; text
      :editable-text
      (let [id (str "EDIT-" (:id @row) "_" (subs (str column) 1))]
        [:div
         [:a {:href "#" :id id
              :data-pk 1
              :data-type "textarea"
              :data-original-title "aoeuaoeu"} (get @row column)]
         [:script {:type "text/javascript"}
          (str "$(function(){$('#" id "').editable({url:'/" (name domain) "/edit/" id "', type:'text', pk:1, name:'" id "'});});")]])

      
      ;; dates
      :date
      (let [id (str "EDIT-" (:id @row) "_" (subs (str column) 1))]
        [:div
         [:a {:href "#" :id id
              :data-pk 1
              :data-type "date"
              :data-original-title "aoeuaoeu"} (get @row column)]
         [:script {:type "text/javascript"}
          (str "$(function(){$('#" id "').editable({url:'/" (name domain) "/edit/" id "', type:'datetime', format: 'mm/dd/yyyy', viewformat:'mm/dd/yyyy', pk:1});});")]])



      (if (data/has-domain coltype)
        
        ;; foreign key to: item
        (let [id (str "EDIT-" (:id @row) "_" (name column))]
          [:div
           [:a {:href "#" :id id
                :data-pk 1
                :data-type "select2"
                :data-value "text"
                :data-source (str "/" (name coltype) "/names")
                :data-title (name domain)
                :class "editable editable-click"
                } (let [foreign-id (get @row column)]
                    (if (and foreign-id (not (= foreign-id "")))
                      (data/row-name @(data/find-row-by-stringid coltype foreign-id))
                      foreign-id))]
           [:script {:type "text/javascript"}
            (str "$(document).ready(function(){$('#" id "').editable({select2:{width:400,placeholder:'Select " (name domain) "',allowClear:true},url:'/" (name domain) "/edit/" id "'});});" )
            ]])
        
        ;; default to read-only text
        (let [v (get @row column)]
          (if v v "n/a"))))))

(comment (drop-down (subs (str coltype) 1)
                    (into [] (map #(vec [(data/row-name @%) (:id @%)]) (grotte.data/find-rows coltype)))
                    (if (get @row column) [(data/row-name @(get @row column)) (:id @(get @row column))])))

(defn domain-table
  "Renders an HTML table with all the rows for this domain.  It
  delegates to render-cell to figure out exactly how each cell should
  be rendered.  Of course, There's no sorting or filtering yet."

  [domain]
  (let [rows (filter #(not (:deleted @%)) @(get @data/*rows* domain))]
    [:div
     [:table {:border "0" :cellspacing "5px"}
      [:tr [:td] [:td]
       (for [k (data/columns-for domain)]
         [:th (str k) [:a {:href (str "/" (subs (str domain) 1) "/drop-column/" (subs (str k) 1))} "(x)"]])
       [:th
        [:a {:href "#" :onclick "alert('jqueryui magic goes here')"} "(+ col)"]
        [:div {:id "acpd" :style "display:relative;"} [:ul [:li "name"] [:li "type"]]]]]
      (for [row rows]
        [:tr {:id (:id @row)}
         [:script {:type "text/javascript"} (str "ajaxClick(\"#DEL-" (:id @row) "\","
                                               "{type: \"GET\", "
                                               " url: \"/" (subs (str domain) 1) "/delete/" (:id @row) "\","
                                               " dataType: \"html\", success: ajaxRemove(\"#" (:id @row) "\"),"
                                               " error: null, confirm: null})")]
         [:td [:a {:href "#" :id (str "DEL-" (:id @row))} "(x)"]]
         [:td [:a {:href (str "/" (subs (str domain) 1) "/show/" (:id @row))} "show"]]
         (for [k (data/columns-for domain)]
           [:td (render-cell domain row k)])])
      [:tr
       [:td {:colspan 2}]
       [:td {:colspan (count (data/columns-for domain))}
        [:a {:href (str "/" (name domain) "/create")} "(+ row)"]]]]
     [:div {:id "test"}]
     ]))

(defn domain-names-json
  ([domain k nm]
     (let [rows (filter #(not (:deleted @%)) @(get @data/*rows* domain))]
       (json/write-str (into [] (map #(assoc {} :id (str (k @%)) :value (str (nm @%)) :text (str (nm @%))) rows)))))
  ([domain nm]
     (domain-names-json domain :id nm))
  ([domain]
     (domain-names-json domain :id data/row-name)))

(defn domain-page
  [domain]
  (html [:head
         [:title (str domain)]
         [:script {:src "http://code.jquery.com/jquery-1.10.1.min.js"}]
         [:link {:href "/select2.css" :rel "stylesheet"}]
         [:link {:href "/select2-bootstrap.css" :rel "stylesheet"}]
         [:script {:src "/select2.js"}]
         [:link {:href "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" :rel "stylesheet"}]
         [:link {:href "//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.6/bootstrap-editable/js/bootstrap-editable.css"}]
         [:script {:src "//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"}]
         [:script {:src "//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.6/bootstrap-editable/js/bootstrap-editable.min.js"}]

         ;;; Two js functions from from conjure originally
         [:script "function ajaxClick(id, ajaxOptions) {$(document).ready(function () {$(id).click(function (e) {e.preventDefault(); if ((ajaxOptions.confirm == null) || (ajaxOptions.confirm())) { $.ajax(ajaxOptions);}});});};function ajaxRemove(id) {return function (data) {$(id).fadeOut(300, function () {$(id).remove();});}};"]

         [:link {:href "//cdnjs.cloudflare.com/ajax/libs/x-editable/1.4.6/bootstrap-editable/css/bootstrap-editable.css" :rel "stylesheet"}]]
        [:body
         [:p [:a {:href "/"} "Home"] " &#8212; " [:b (str domain)]]
         [:h1 (str domain " list")]
         (domain-table domain)
         ]))

(defn ref? [x]
  (and (not (nil? x)) (= "class clojure.lang.Ref" (str (class x)))))

(defn row-page
  [domain id]
  (html [:head
	 [:title (str domain "s")]
   [:link {:href "jqueryui.css" :rel "stylesheet" :type "text/css"}]
	 [:script {:type "text/javascript" :src "jquery.min.js"}]
	 [:script {:type "text/javascript" :src "jqueryui.min.js"}]
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
				     [:li (data/row-name row)]
             [:ul (for [k (filter #(not (= % :parent)) (keys row))] [:li [:b k] "&#8212;" (get row k)])]]))))]
	     x))
	 [:hr]]))

(defn history-page
  []
  (html [:head [:title "History"]]
        [:body
         [:h1 "All change history"]
         [:ul
          (for [line (prevail/history)]
            [:li [:tt line]])]]))

;(def jquery-jeditable (slurp "src/js/jquery.jeditable.js"))
;(def jquery-jeditable-datepicker (slurp "src/js/jquery.jeditable.datepicker.js"))
;(def conjure-js (slurp "src/js/conjure.js"))
;(def jquery-ui-js (slurp "src/js/jquery-ui.min.js"))
;(def jquery-ui-css (slurp "src/js/jquery-ui.css"))
(def jquery-js (slurp "src/js/jquery.min.js"))
(def select2-js (slurp "src/js/select2-3.4.5/select2.js"))
(def select2-css (slurp "src/js/select2-3.4.5/select2.css"))
(def select2-bootstrap-css (slurp "src/js/select2-3.4.5/select2-bootstrap.css"))
(def select2-png (slurp "src/js/select2-3.4.5/select2.png"))
(def select2-2-png (slurp "src/js/select2-3.4.5/select2x2.png"))

(defroutes the-routes
  (GET "/" []
       (root-page))

  (GET "/now" []
       (now))
  ;(GET "*conjure.js" [] conjure-js)
  ;(GET "*jquery.jeditable.js" [] jquery-jeditable)
  ;(GET "*jquery.jeditable.datepicker.js" [] jquery-jeditable-datepicker)
  ;(GET "*jquery.min.js" [] jquery-js)
  ;(GET "*jquery.js" [] jquery-js)
  ;(GET "*jqueryui.min.js" [] jquery-ui-js)
  ;(GET "*jqueryui.css" [] jquery-ui-css)
  (GET "*select2.js" [] select2-js)
  (GET "*select2.css" [] select2-css)
  (GET "*select2-bootstrap.css" [] select2-bootstrap-css)
  (GET "*select2.png" [] select2-png)
  (GET "*select2x2.png" [] select2-2-png)

  (GET "/history" []
       (history-page))

  (GET "/:domain" [domain]
       (domain-page (keyword domain)))
  (GET "/:domain/names" [domain]
       (domain-names-json (keyword domain)))
  (GET "/:domain/show/:id" [domain id]
       (row-page (keyword domain) id))
  (GET "/:domain/delete/:id" [domain id]
       (prevail/prevail grotte.data/delete-row-by-idstring (keyword domain) id))
  (GET "/:domain/drop-column/:column-name" [domain column-name]
       (prevail/prevail grotte.data/drop-column (keyword domain) (keyword column-name))
       (redirect (str "/" domain)))
  (GET "/:domain/create" [domain]
       (let [uuid (.toString (java.util.UUID/randomUUID))]
         (prevail/prevail grotte.data/make-row (keyword domain) :id uuid))
       (redirect (str "/" domain)))
  (GET "/:domain/add-column/:column-name/:column-type" [domain column-name column-type]
       (prevail/prevail grotte.data/add-column (keyword domain) (keyword column-name) (keyword column-type))
       (redirect (str "/" domain)))
  (POST "/:domain/add-column" {params :params} []
        (prevail/prevail grotte.data/add-column (keyword (params :domain)) (keyword (params :column-name)) (keyword (params :column-type)))
        (redirect (str "/" (params :domain))))
  (POST "/create-domain" {params :params} []
       (prevail/prevail grotte.data/create-domain (keyword (params :domain)))
       (redirect (str "/" (params :domain))))
  (POST "/:domain/edit/:id" {params :params} []
        (do
          (prn params)
          (let [column-name (subs (params :id) 42)
                value (params :value)
                domain (params :domain)
                real-id (subs (params :id) 5 41)]  ;; 5 is just (count "EDIT-")
            (prevail/prevail grotte.data/update-row-by-idstring (keyword domain) real-id (keyword column-name) value)
            value)))

  (compojure.route/not-found "404: Fail whale"))


(def app (compojure.handler/api (var the-routes)))

(defonce server (ref nil))
(defn start-server
  []
  (dosync (ref-set server (jetty/run-jetty app {:port 4000 :join? false}))))
(defn stop-server
  []
  (.stop @server))


