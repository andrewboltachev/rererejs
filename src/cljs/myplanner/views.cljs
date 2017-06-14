(ns myplanner.views
  (:require [re-frame.core :as re-frame]))


;; home

(defn home-panel []
  (let [name (re-frame/subscribe [:name])]
    (fn []
      [:div (str "Hello from " @name ". This is the Home Page.")
       [:div [:a {:href "/about"} "go to About Page"]]])))


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
        [:div [:a {:href "/"} "go to Home Page"]]])))


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
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [:div.container
       [:div.row
        [:div.col-md-12
         [:> js/ReactBootstrap.Button
          {:on-click
           #(re-frame/dispatch [:say-hello "World"])}
          "Foo"]
         [show-panel @active-panel]]]])))
