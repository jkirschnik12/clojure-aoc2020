(ns aoc.day6.day6
  (:require [clojure.string :as str])
  (:require [clojure.set])
  (:gen-class))



(defn part1
  []
  (->> (str/split (slurp "src/aoc/day6/input.txt") #"\n\n")
       (map #(count (set (str/replace % "\n" ""))))
       (reduce +)))

(defn recursive
  [output input]
  (if (not (empty? input))
    (recur (clojure.set/intersection (first input) output) (drop 1 input))
    output))

(defn part2
  []
  (->> (str/split (slurp "src/aoc/day6/input.txt") #"\n\n")
       (map #(map set (str/split % #"\n")))
       (map #(if (> (count %) 1)
               (recursive (clojure.set/intersection (first %) (second %)) (drop 2 %))
               (first %)))
       (map count)
       (reduce +)))

(comment
  (part1)
  (part2))