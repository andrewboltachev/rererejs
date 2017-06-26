(ns myplanner.views
  (:require [re-frame.core :as re-frame]
            [reagent.core :as reagent]))

(defn main-panel []
  (let [types [{:key nil
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
          [:a {:href "/about"} "About"]
          [:div.col-md-6.col-md-offset-3
            [:h1 "Data"]
           #_[:> js/ReactBootstrap.Button
            {:on-click
             #(re-frame/dispatch [:say-hello "World"])}
            "Foo"]


       
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
                             [:set :data (.. % -target -value)])}
               ]

          (= (:key t) :vector)
              ^{:key "vector"}
          (let [
                ;list-item (fn [title]
                ;            [:li.list-group-item title])



SortableItem (js/SortableElement (fn [__obj0] (let [value (.-value __obj0)]
                                             (reagent/as-component
                                             [:li.list-group-item {}
                                              [:div
                                               [:>
             js/ReactBootstrap.FormGroup
             {:controlId "data"}
              [:> js/ReactBootstrap.ControlLabel
               "Data"]
                                                
                                                [:>
               js/ReactBootstrap.FormControl
               {:value data
                :onChange #(re-frame/dispatch
                             [:set :data ])}
               ]
                                                ]





                                               value]
                                              ]))))


 SortableList
 (js/SortableContainer
  (fn
   [__obj0]
   (let
    [items (.-items __obj0)]
 (reagent/as-component
    (vec (concat [:ul.list-group
     {}
     "\n                    "]
     (js->clj
       (.map items (fn [value index] [:> SortableItem {:key (str "item-" index), :index index, :value value}])))
     ["\n                                            "]))
   ))))


 SortableComponent
 (.createClass
  js/React
  #js {:getInitialState (fn [] (let [] #js {:items (clj->js ["Item 1" "Item 2" "Item 3" "Item 4" "Item 5" "Item 6"])})), :onSortEnd (fn [__obj0] (this-as this (let [oldIndex (.-oldIndex __obj0) newIndex (.-newIndex __obj0)] (.setState this #js {:items (js/Sortable.arrayMove (.-items (.-state this)) oldIndex newIndex)})))), :render (fn [] (this-as this (reagent/as-component [:> SortableList {:items (.-items (.-state this)), :onSortEnd (.-onSortEnd this)}])))})




                ]
            [:> SortableComponent]
            )
              
          :else
          [:div
           "Data input not implemented"])
             ]
       
       
       
       
       
       ]])








           ]]]))
