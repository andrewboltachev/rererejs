(ns myplanner.events
  (:require [re-frame.core :as re-frame]
            [myplanner.db :as db]))

(re-frame/reg-fx
  :say-hello
  (fn [whom]
    (js/console.log (str "Hello, " whom "!"))))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :set-active-panel
 (fn [db [_ active-panel route-params]]
   (merge db {:active-panel active-panel
              :route-params route-params})))

(re-frame/reg-event-db
 :set
 (fn [db [_ path value]]
   (js/console.log :set path value)
   (let [path (if (sequential? path) path [path])]
     (assoc-in db path value))))

(re-frame/reg-event-fx
  :say-hello
  (fn [_ [_ whom]]
    {:say-hello whom}))
