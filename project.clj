(defproject d3demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[noir "1.3.0-beta10"]
                 [jayq "0.1.0-alpha4"]
                 [crate "0.2.1"]
                 [fetch "0.1.0-alpha2"]
                 [org.clojure/clojure "1.4.0"]]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :main d3demo.core
  :cljsbuild {:builds
              [{:source-path "src"
                :compiler {:output-to "resources/public/js/main-debug.js"
                           :optimizations :whitespace
                           :pretty-print true}}]})
