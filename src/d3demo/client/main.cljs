(ns d3demo.client.main
  (:use [jayq.util :only [wait clj->js log]])
  (:require [clojure.browser.repl :as repl]))


(defn random-data []
  (clj->js (for [n (range 1 (rand-int 8))]
             {:id n
              :x (inc (rand-int 300))
              :y (inc (rand-int 300))
              :r (inc (rand-int 20))})))


(defn scaler [range domain]
  (-> js/d3
      .-scale
      .linear
      (.range (clj->js range))
      (.domain (clj->js domain))))

(defn ^:export main []
  (let [scale (scaler [20 180] [0 300])
        circles (-> (.select js/d3 "#visualisation")
                    (.selectAll "circle")
                    (.data (random-data)))]
    (-> circles .enter
        (.append "circle")
        (.attr "cx" (fn [d] (scale (.-x d))))
        (.attr "cy" (fn [d] (scale (.-y d))))
        (.style "fill" "red"))

    (-> circles .transition
        (.duration 1000)
        (.ease "exp-in-out")
        (.attr "cx" (fn [d] (scale (.-x d))))
        (.attr "cy" (fn [d] (scale (.-y d))))
        (.attr "r" (fn [d] (.-r d))))

    (-> circles .exit
        .transition
        (.duration 1000)
        (.ease "exp-in-out")
        (.attr "r" 0)
        .remove)

    (wait 2000 main)))

(defn ^:export repl []
  (repl/connect "http://localhost:9000/repl"))
