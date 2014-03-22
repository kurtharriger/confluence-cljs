(defproject cljs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2138"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [reagent "0.2.0"]]
  :plugins [[lein-cljsbuild "1.0.1"]]
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "cljs/demo.js"
                                   :output-dir "cljs"
                                   :optimizations :none
                                   ;; preamble works great to include
                                   ;; additional dependencies in simple/advanced mode
                                   ;; but is ignored when optimization is none
                                   :preamble ["js/react.js"]
                                   :externs ["js/react.js"]
                                   :source-map true
                                   :pretty-print true}}]})
