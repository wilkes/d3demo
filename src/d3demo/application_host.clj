(ns d3demo.application-host
  (:use [noir.core :only (defpartial)]
        [hiccup.page :only (html5
                            include-css
                            include-js)]
        [hiccup.element :only (javascript-tag)]))

(defpartial layout []
  (html5
   [:head
    [:title "D3 Demo"]
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "Content-Type" :content "text/html; charset=UTF-8"}]
    (include-js "http://d3js.org/d3.v2.js"
                "js/jquery-1.7.1.min.js"
                "js/main-debug.js")]
   [:body
    [:svg#visualisation {:width 200 :height 200 :style "border: 1px solid black"}]
    [:div]
    (javascript-tag "d3demo.client.main.main();")]))
