(ns ml-db.core
  (:require [ml-db.get-data :as get-data]
            [clj-time.format :as f])
  (:import [javafx.geometry Insets Pos]
           [javafx.scene.chart NumberAxis CategoryAxis]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Window size ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def width 600)
(def height 400)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def initial-state
  {:root-stage? true})

(defonce root-state (atom initial-state))

(def custom-formatter (f/formatter "yyyy-MM-dd"))



(defn set-v-box [])

(defn set-scene []
  " arguments means children \n
  scene
   |- h-box
       |- LineChart
       |- v-box
           |- 
  "
  (let []
    (doto (Scene. (set-v-box) (+ 250 width) (+ 200 height)))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; NECESSARY UTILITY ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defn force-exit
  " This is closed function \n"
  [root-stage?]
  (reify javafx.event.EventHandler
    (handle [this event]
      (when (not root-stage?)
        (do (println "Closing application")
            (javafx.application.Platform/exit))))))

(defn swap
  " This is change state of initialize \n"
  [root-stage?]
  (dosync (ref-set data-state {:root-stage? root-stage?
                               :pos {:x-min -2 :x-max 1 :y-min -1 :y-max 1}
                               :color (Color/GREENYELLOW)
                               :redraw? false})))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
