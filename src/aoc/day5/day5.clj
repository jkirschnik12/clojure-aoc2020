(ns aoc.day5.day5
  (:require [clojure.string :as string]
            [clojure.string :as str])
  (:gen-class))
(defn parse-seat
  [seat]
  ;; F=0, B=1 64 32 16 8 4 2 1
  ;; L=0, R=1
  (let [row-weights [64 32 16 8 4 2 1]
        col-weights [4 2 1]]
    (into {:row    (->> (take 7 seat)
                        (map #(if (= % \F) 0 1))
                        (map #(* %1 %2) row-weights)
                        (reduce +))
           :column (->> (drop 7 seat)
                        (map #(if (= % \L) 0 1))
                        (map #(* %1 %2) col-weights)
                        (reduce +))})))


(defn part1
  []
  (->> (slurp "src/aoc/day5/input.txt")
       (str/split-lines)
       (map parse-seat)
       (map #(+ (* (:row %) 8) (:column %)))
       (sort)
       ))
;;First non-nil value in return is answer
;;Not the best way to solve, but does generate correct answer
(defn part2
  []
  (let [complete (range 70 939)]
    (->> (slurp "src/aoc/day5/input.txt")
         (str/split-lines)
         (map parse-seat)
         (map #(+ (* (:row %) 8) (:column %)))
         (sort)
         (map #(if (not (= %1 %2)) %1 nil) complete)
         (filter (complement nil?))
         (first))))

(comment
  (part1)
  (part2))