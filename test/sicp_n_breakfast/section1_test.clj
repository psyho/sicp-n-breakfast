(ns sicp-n-breakfast.section1-test
  (:use midje.sweet
        sicp-n-breakfast.section1))

(fact
  (divides? 2 10) => true
  (divides? 3 10) => false
  (divides? 1 10) => true)

(fact
  (smallest-divisor 10) => 2
  (smallest-divisor 1) => 1
  (smallest-divisor 4) => 2
  (smallest-divisor 7) => 7)

(fact
  (prime? 2) => true
  (prime? 3) => true
  (prime? 4) => false
  (prime? 5) => true
  (prime? 6) => false
  (prime? 1000000005) => false
  (prime? 7) => true)

(fact
  (smallest-primes-over 10 prime?) => [11 13 17]
  (smallest-primes-over 100 prime?) => [101 103 107])

(fact
  solution-1-21 => [199 1999 7])

(fact
  (prime-next? 2) => true
  (prime-next? 3) => true
  (prime-next? 4) => false
  (prime-next? 5) => true
  (prime-next? 6) => false
  (prime-next? 1000000005) => false
  (prime-next? 7) => true)

(fact
  (fast-prime? 2 20) => true
  (fast-prime? 3 20) => true
  (fast-prime? 4 20) => false
  (fast-prime? 5 20) => true
  (fast-prime? 6 20) => false
  (fast-prime? 1000000005 20) => false
  (fast-prime? 7 20) => true)
