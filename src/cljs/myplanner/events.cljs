(ns myplanner.events
  (:require [re-frame.core :as re-frame]
            [myplanner.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel route-params]]
   (merge db {:active-panel active-panel
              :route-params route-params})))
