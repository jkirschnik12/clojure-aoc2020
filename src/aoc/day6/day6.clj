(ns aoc.day6.day6
  (:require [clojure.string :as str])
  (:gen-class))



(defn part1
  []
  (->> (-> (slurp "src/aoc/day6/input.txt")
           (str/split #"\n\n"))
       (map #(count (set (str/replace % "\n" ""))))
       (reduce +)))
(defn part2
  []
  )
(comment
  (part1)
  (part2))