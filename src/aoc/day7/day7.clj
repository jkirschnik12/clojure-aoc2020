(ns aoc.day7.day7
  (:require [clojure.string :as str])
  (:gen-class))

(defn part1
  []
  (def target-bag "shiny gold")
  (->> (slurp "src/aoc/day7/input.txt")
       (str/split-lines)
       (map #(str/split % #" "))
       (map (fn [line]
              (remove #(or (= % "bag,") (= % "bags.") (= % "bags") (= % "bags,") (= % "contain") (= % "bag.")) line)))
       (map #(into {:name (str/join " " (take 2 %))
                    :children (drop 2 %)}))
       (map #(assoc % :children (partition 3 (:children %))))
       (map (fn [line]
              (map #(into {:name (drop 1 %) :amount (take 1 %)}) (:children line))))))

(comment
  (part1))