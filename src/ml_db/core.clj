(ns ml-db.core
  (:require [ml-db.get-data :as get-data]
            [clj-time.format :as f])
  (:import [javafx.geometry Insets Pos]
           [javafx.scene.chart NumberAxis CategoryAxis]
           [javafx.scene.layout VBox HBox]
           [javafx.scene Scene]
           [javafx.scene.chart LineChart]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Window size ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(def width 600)
(def height 400)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(def initial-state
  {:root-stage? true})

(defonce data-state (ref initial-state))

(def custom-formatter (f/formatter "yyyy-MM-dd"))

(def v-box (VBox.))
(def line-chart (LineChart. (CategoryAxis.) (NumberAxis.)))
(def h-box (HBox.))

(defn set-v-box []
  )

(defn set-line-chart []
  )

(defn set-h-box []
  )

(defn set-scene []
  " arguments means children \n
  scene
   |- h-box
       |- LineChart
       |- v-box
           |- 
  "
  (let []
    (doto (Scene. (set-h-box) (+ 250 width) (+ 200 height)))))


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
  (dosync (ref-set data-state {:root-stage? root-stage?})))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
