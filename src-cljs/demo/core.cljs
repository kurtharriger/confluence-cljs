(ns demo.core
  (:require
   [cljs.core.async :as async :refer [<! >! chan ]]
   [reagent.core :as r :refer [atom]])
  (:require-macros [cljs.core.async.macros :as m :refer [go go-loop alt!]]))

(def model (atom []))
(defn godemo1 [] [:div (for [msg (take-last 5 @model)] [:p msg])])
(r/render-component [godemo1] (.getElementById js/document "godemo1"))



(def c (chan))
(go (while true (<! (async/timeout 250)) (>! c 1)))
(go (while true (<! (async/timeout 1000)) (>! c 2)))
(go (while true (<! (async/timeout 1500)) (>! c 3)))
(go (while true (swap! model conj (<! c))))


(.addEventListener
 (.getElementById js/document "gocode1") "click" (fn [] (js* "debugger") nil))
