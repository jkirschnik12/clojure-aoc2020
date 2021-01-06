(ns aoc.day6.day6
  (:require [clojure.string :as str])
  (:require [clojure.set])
  (:gen-class))



(defn part1
  []
  (->> (str/split (slurp "src/aoc/day6/input.txt") #"\n\n")
       (map #(count (set (str/replace % "\n" ""))))
       (reduce +)))

(defn part2
  []
  (->> (str/split (slurp "src/aoc/day6/input.txt") #"\n\n")
       (map #(map set (str/split % #"\n")))
       (map #(reduce clojure.set/intersection %))
       (map count)
       (reduce +)))

(comment
  (part1)
  (part2))