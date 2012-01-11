(grotte.data/make-row :post :id "9f99ccee-80da-4d29-819e-609ec637a57f") ;1
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :body "Thi ssi the body") ;2
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :pubdate "12/29/2011") ;3
(grotte.data/make-row :post :id "68b1ea82-5d8d-469e-afa8-3acc47d8cd69") ;4
(grotte.data/update-row-by-idstring :post "68b1ea82-5d8d-469e-afa8-3acc47d8cd69" :body "Monkey") ;5
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :body "This is the body") ;6
(grotte.data/make-row :post :id "6766badf-1552-49a7-896a-44c3158065b9") ;1
(grotte.data/update-row-by-idstring :post "6766badf-1552-49a7-896a-44c3158065b9" :body "Fish") ;2
(grotte.data/update-row-by-idstring :post "6766badf-1552-49a7-896a-44c3158065b9" :pubdate "01/01/2012") ;3
(grotte.data/update-row-by-idstring :post "68b1ea82-5d8d-469e-afa8-3acc47d8cd69" :pubdate "01/01/2012") ;1
(grotte.data/update-row-by-idstring :post "6766badf-1552-49a7-896a-44c3158065b9" :pubdate "01/02/2012") ;2
(grotte.data/make-row :post :id "d4c550a5-e162-42bb-8b62-b9a8c47e0966") ;1
(grotte.data/update-row-by-idstring :post "d4c550a5-e162-42bb-8b62-b9a8c47e0966" :body "Added a row with my fancy new widget.") ;2
(grotte.data/update-row-by-idstring :post "d4c550a5-e162-42bb-8b62-b9a8c47e0966" :pubdate "1/1/1") ;3
(grotte.data/update-row-by-idstring :post "d4c550a5-e162-42bb-8b62-b9a8c47e0966" :pubdate "01/02/2001") ;4
(grotte.data/update-row-by-idstring :post "d4c550a5-e162-42bb-8b62-b9a8c47e0966" :pubdate "12/31/1999") ;5
(grotte.data/add-column :post :age :integer) ;6
(grotte.data/drop-column :post :age) ;7
(grotte.data/add-column :post :age :editable-text) ;8
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :age "25") ;9
(grotte.data/update-row-by-idstring :post "6766badf-1552-49a7-896a-44c3158065b9" :age "90000abcdefghij") ;10
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :body "This is the body. Indeed!") ;11
(grotte.data/add-column :post :aeou :uuu) ;1
(grotte.data/add-column :post :color :editable-text) ;2
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :color "blue") ;3
(grotte.data/update-row-by-idstring :post "6766badf-1552-49a7-896a-44c3158065b9" :color "orange") ;4
(grotte.data/drop-column :post :aeou) ;5
(grotte.data/add-column :post :pubdate :date) ;1
(grotte.data/drop-column :post :pubdate) ;2
(grotte.data/add-column :post :pubdate :date) ;3
(grotte.data/drop-column :post :body) ;4
(grotte.data/add-column :post :body :editable-text) ;5
(grotte.data/update-row-by-idstring :post "9f99ccee-80da-4d29-819e-609ec637a57f" :body "This is the body. Indeed! And it's editable!") ;6
(grotte.data/create-domain :comment) ;1
(grotte.data/add-column :comment :body :editable-text) ;2
(grotte.data/make-row :comment :id "aa378e3b-3445-4320-b9f1-a70e78362a61") ;3
(grotte.data/add-column :comment :post :post) ;4
(grotte.data/update-row-by-idstring :comment "aa378e3b-3445-4320-b9f1-a70e78362a61" :body "This is a comment, but it has nowhere to live!") ;5
(grotte.data/add-column :post :label :text) ;6
(grotte.data/drop-column :comment :post) ;7
(grotte.data/add-column :comment :post :post) ;8
(grotte.data/drop-column :comment :body) ;9
(grotte.data/add-column :comment :body :editable-text) ;10
