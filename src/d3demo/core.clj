(ns d3demo.core
  (:use [noir.core :only (defpage)]
        [d3demo.application-host :only (layout)])
  (:require [noir.server :as server]))

(defpage "/" [] (layout))

(defn run-server [& [p]]
  (let [port (or p 8080)]
    (server/start port {:mode :dev
                        :ns 'd3-demo})))

(comment
  (do
    (use 'd3demo.core)
    (run-server)))
