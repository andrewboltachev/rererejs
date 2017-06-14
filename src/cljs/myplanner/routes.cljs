(ns myplanner.routes
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as rf]
            [myplanner.utils :refer [uri->query-params]]))

(def app-routes
  ["/" {"" :home-panel
        "about" :about-panel
        ["articles/" :id] :articles-panel}])

(defn set-page! [match]
  (js/console.log "match" match)
  (rf/dispatch [:set-active-panel
                (:handler match)
                (:route-params match)]))

(def history
  (pushy/pushy set-page! (fn [uri]
                           (let [result ((partial bidi/match-route app-routes) uri)
                                 result
                                 (when result
                                  (assoc
                                    result
                                    :query-params (uri->query-params uri)))]
                             result))))

(defn start []
  (pushy/start! history))
