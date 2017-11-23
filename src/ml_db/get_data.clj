(ns ml-db.get-data
  (:require [clj-quandl-api.core :as quandl]
            [clj-time.core :as t])
  (:gen-class))

(quandl/set-api-key! "8zvcussLPAzz7xbdisQb")

(defmulti get-data
  " get date from quandl (\" https://www.quandl.com/ \")
  require:
  [^String title ^Long rows ^String collapse]
  [^String title ^clj-time.core/date-time start_date ^String collapse]
  [^String title ^clj-time.core/date-time start_date
  ^clj-time.core/date-time end_date ^String collapse ]
  usage:
  (get-data \"NIKKEI/ALL_STOCK\" 10 \"weekly\")
  (get-data \"NIKKEI/ALL_STOCK\" (clj-time.core/date-time 2017 10 30) \"weekly\")
  (get-data \"NIKKEI/ALL_STOCK\" (clj-time.core/date-time 2017 10 30)
            (clj-time.core/date-time 2017 11 20) \"weekly\")
  
  developer's announce:
  quandl/quandl's map has these options
  - :collapse \"none\" \"daily\" \"weekly\" \"monthly\" \"quarterly\" \"annual\"
  - :transform \"none\" \"rdiff\" \"diff\" \"cumul\" \"normalize\"
  - :order \"asc\" \"desc\"
  - :rows integer
  - :limit integer
  - :start_date clj-time.core/date-time
  - :end_date clj-time.core/date-time
  "
  (fn [x y z & xs]
    (mapv class (into [x y z] xs))))

(defmethod get-data
  [String]
  [title]
  (quandl/quandl title))

(defmethod get-data
  [String Long String]
  [title rows collapse]
  (quandl/quandl title :rows rows :collapse collapse))

(defmethod get-data
  [String org.joda.time.DateTime String]
  [title start_date collapse]
  (quandl/quandl title :start_date start_date :collapse collapse))

(defmethod get-data
  [String org.joda.time.DateTime org.joda.time.DateTime String]
  [title start_date end_date collapse]
  (quandl/quandl title :start_date start_date :end_date end_date :collapse collapse))



(def test-title "NIKKEI/ALL_STOCK")
(def test-row-length 100)
(def test-collapse "weekly")
(def example-data4 (get-data test-title test-row-length test-collapse))


