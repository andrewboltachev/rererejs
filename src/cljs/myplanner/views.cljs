(ns myplanner.views
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent]))


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
        
        
        types [{:key nil
                :title "Nil"
                :test nil?
                :empty nil}
               {:key :string
                :title "String"
                :test string?
                :empty ""}
                ;{:key :number
                ;:title "Number"
                ; :test number?
                ; :empty 0}
               {:key :vector
                :title "Vector"
                :test vector?
                :empty []}
               {:key :map
                :title "Map"
                :test map?
                :empty {}}]
        value->type
        (fn [v]
          (first (filter #((:test %) v) types)))
        type->its-key-as-str
        (fn [t]
          (let [k (:key t)]
            (if (nil? k) "" (name k))))
        ;types (partition 2 types)
        its-key->type
        (fn [k]
          (first (filter #(= (:key %) k) types)))
        
            
        data @(re-frame.core/subscribe [:get :data])
        
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



       
           (let [t
                 (value->type data)
                 _ (js/console.log "data is" data (type data) t)
                 ]
             [:div
       [:form
        {:on-submit #(do
                       (.predentDefault %)
                       false)}
            [:>
             js/ReactBootstrap.FormGroup
             {:controlId "type"}
              [:> js/ReactBootstrap.ControlLabel
               "Type"]
             ;(println "value" (:type @data))
              [:>
               js/ReactBootstrap.FormControl
               {:componentClass "select"
                :value (type->its-key-as-str t)
                :onChange #(re-frame/dispatch [:set :data (:empty
                                                            (its-key->type
                                                            (keyword
                                                              (.. % -target -value)))
                                                            
                                                            )])}
               (for [t types]
                 (let [k (type->its-key-as-str t)]
                    ^{:key k}
                    [:option
                      {:value k}
                      (:title t)]))
               ]
             ]
       
       [:>
             js/ReactBootstrap.FormGroup
             {:controlId "data"}
              [:> js/ReactBootstrap.ControlLabel
               "Data"]
        (cond
          (= (:key t) nil)
              ^{:key ""}
          [:>
               js/ReactBootstrap.FormControl
               {:defaultValue "Nil"
                :disabled true}
               ]

          (= (:key t) :string)
              ^{:key "string"}
              [:>
               js/ReactBootstrap.FormControl
               {:value data
                :onChange #(re-frame/dispatch
                             [:set :data ])}
               ]

          (= (:key t) :vector)
              ^{:key "vector"}
          (let [
                ;list-item (fn [title]
                ;            [:li.list-group-item title])







 ListItem
 (.createClass
  js/React
  #js {:displayName "SortableListItem", :render (fn [] (this-as this
                                                                (reagent/as-component [:div {:className "list-group-item"} (.-children (.-props this))])))})


SortableListItem (js/ReactSortable.sortable ListItem)


 SortableList
 (.createClass
  js/React
  #js {:getInitialState
       (fn []
         (this-as this
                  #js {:draggingIndex nil, :data (.-data (.-props this))})),
       :updateState
       (fn [obj]
         (js/console.log "update state")
         (this-as this
                  (.updateState this obj))),
       :render
       (fn []
         (this-as this
                  (let [childProps #js {}
                        listItems (.map (.-items (.-data (.-state this)))
                                        (fn [item i]
                                          (js/console.log i SortableListItem)
                                          (this-as this
                                                   (reagent/as-component
                                                     [:>
                                                      SortableListItem
                                                    {:key i,
                                                     :updateState (.-updateState this),
                                                     :items (.-items (.-data (.-state this))),
                                                     :draggingIndex (.-draggingIndex (.-state this)),
                                                     :sortId i,
                                                     :outline "list",
                                                     :childProps childProps}
                                                      (do
                                                    item
                                                        )
                                                      ])))
                                        this)]
                    (reagent/as-component [:div {:className "list"} listItems]))))})










                ]
              ;js/ReactSortable.sortable
            [:div
             [:>
              js/SortableList
              {:data #js {:items #js ["Foo" "Bar" "Buz"]}}]])
              
          :else
          [:div
           "Data input not implemented"])
             ]
       
       
       
       
       
       ]])








           ]]]))
