(ns sicp-n-breakfast.section1)

; Section 1.2.6 - Testing for primality

(defn divides? [a b]
  (zero? (rem b a)))

(defn square [n] (* n n))

(defn smallest-divisor [n]
  (loop [n n
         test-divisor 2]
    (cond 
      (> (square test-divisor) n) n
      (divides? test-divisor n) test-divisor
      :else (recur n (inc test-divisor)))))

(defn prime? [n]
  (= n (smallest-divisor n)))

(def solution-1-21
  (map smallest-divisor [199 1999 19999]))

(defn odd-larger-than [n] (filter odd? (iterate inc n)))

(defn smallest-primes-over [x prime-check]
  (take 3 (filter prime-check (odd-larger-than x))))

(defn solution-1-22 []
  (println "Solution 1.22")
  (doseq [n [1000 10000 100000 1000000 1000000000]]
    (println (time (smallest-primes-over n prime?)))))

(solution-1-22)

(defn next-to-check [n]
  (cond
    (= 2 n) 3
    :else (+ n 2)))

(defn smallest-divisor-next [n]
  (loop [n n
         test-divisor 2]
    (cond 
      (> (square test-divisor) n) n
      (divides? test-divisor n) test-divisor
      :else (recur n (next-to-check test-divisor)))))

(defn prime-next? [n]
  (= n (smallest-divisor-next n)))

(defn solution-1-23 []
  (println "Solution 1.23")
  (doseq [n [1000 10000 100000 1000000 1000000000]]
    (println (time (smallest-primes-over n prime-next?)))))

(solution-1-23)

(defn expmod [base exp m]
  (cond 
    (= exp 0) 1
    (even? exp) 
      (rem (square (expmod base (quot exp 2) m)) m)
    :else 
      (rem (* base (expmod base (- exp 1) m)) m)))

(defn random [n]
  (Math/floor (rand n)))

(defn fermat-test [n]
  (let [try-it #(= % (expmod % n n))]
    (try-it (+ 1 (random (- n 1))))))

(defn fast-prime? [n times]
  (cond 
    (= times 0 true)
    (fermat-test n (fast-prime? n (dec times)))
    :else false))

(defn solution-1-24 []
  (println "Solution 1.24")
  (doseq [n [1000 10000 100000 1000000 1000000000]]
    (println (time (smallest-primes-over n #(fast-prime? % 20))))))

;(solution-1-24)
