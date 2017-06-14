(ns myplanner.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 :get
 (fn [db [_ path]]
   (let [path (if (sequential? path) path [path])]
     (get-in db path))))

(re-frame/reg-sub
 :active-panel
 (fn [db _]
   (:active-panel db)))

(re-frame/reg-sub
 :route-params
 (fn [db _]
   (:route-params db)))
