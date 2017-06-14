(ns myplanner.views
  (:require [re-frame.core :as re-frame]))


;; home

(defn home-panel []
  (let [name_ (re-frame/subscribe [:name])
        
        ]
    (fn []
      (let [
            ]
      ))))


;; about

(defn about-panel []
  (fn []
    [:div "This is the About Page."
     [:div [:a {:href "/"} "go to Home Page"]]
     [:div [:a {:href "/articles/42?a=1&b=2"} "go to Article 42"]]]))


;; articles-panel

(defn articles-panel []
  (let [route-params (re-frame/subscribe [:route-params])]
    (fn []
      [:div
        [:div "This is the Article #" (:id @route-params) " Page."]
        [:div [:a {:href "/"} "go to Home Page"]]
       
       
       
       
       
       
       
       
       
       
       
       ])))


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    :articles-panel [articles-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])
        
        
        types [:string "String"
               :number "Number"
               :vector "Vector"
               :map "Map"]
        types (partition 2 types)
        
            
        data (re-frame.core/subscribe [:get :data])
        
        ]
        [:div.container
         [:div.row
          [:div.col-md-6.col-md-offset-3
            [:h1 "Data"]
           #_[:> js/ReactBootstrap.Button
            {:on-click
             #(re-frame/dispatch [:say-hello "World"])}
            "Foo"]
           ;[show-panel @active-panel]



       
       [:form
            [:>
             js/ReactBootstrap.FormGroup
             {:controlId "type"}
              [:> js/ReactBootstrap.ControlLabel
               "Type"]
             ;(println "value" (:type @data))
              [:>
               js/ReactBootstrap.FormControl
               {:componentClass "select"
                :value (name (or (:type @data) :string))
                :onChange #(re-frame/dispatch [:set [:data :type] (keyword (.. % -target -value))])}
               (for [[k v] types]
                 (let [k (name k)]
                    ^{:key k}
                    [:option
                      {:value k}
                      v]))
               ]
             ]
       
       
       
       
       
       
       
       ]








           ]]]))
