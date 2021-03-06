(ns ml-db.javafx-init
  (:require [ml-db.core :as core])
  (:import [javafx.stage Stage]
           [javafx.application Application])
  (:gen-class
   :extends javafx.application.Application))

(defn -start
  " This is javafx-start funnction \n"
  [this ^Stage stage]
  (let []
    (doto stage
      (.setTitle "Test")
      (.setOnCloseRequest (core/force-exit {:root-stage? false}))
      (.setScene (core/set-scene))
      (core/data-state {:root-stage? false})
      .show)))

(defn -main
  " This is javafx-launch function \n"
  [& args]
  (core/swap false)
  (Application/launch ml_db.javafx_init (into-array String [])))
