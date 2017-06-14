(ns myplanner.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [myplanner.events]
            [myplanner.subs]
            [myplanner.routes :as routes]
            [myplanner.views :as views]
            [myplanner.config :as config]))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))
