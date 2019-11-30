;clojure notes to think about


;;load string for this file
;; "C:\\Users\\Raj Wall\\Downloads\\Clojure\\life\\think.clj"
;;say you wanted to seed some random places with 'live' cells in addition 
;;to the ones you specifically bring to life
(def a (take 10 (repeatedly #(rand-int 100))))
(def b (take 10 (repeatedly #(rand-int 100))))

(defn by-pairs [coll]
  (let [take-pair (fn [c]
                    (when (next c) (take 2 c)))]
    (lazy-seq
     (when-let [pair (seq (take-pair coll))]
       (cons pair (by-pairs (rest coll)))))))
(def c (by-pairs (vec (interleave a b))))

;use partition instead: (partition size step? coll), 
; (patition 2 '(x y x y x y))

(def traffic-light '(0 0) (0 1) (0 -1));pattern to be place at some location

;Print functions
; pr - prints with spaces separating
; prn - with newline
;
;update a reference with functions such as swap!
; (swap! ref update-fn & args)
; (swap! v conj 'newb)
;

; vectors [1 2 3]

; maps
; collections of key / value pairs. Anything can be a key
; "keywords" have a colon : :foo

; use clojure core namespace
; (clojure.core/use 'clojure.core)

; import java class (use for android? graphics?
; (import '(package Class+)) ; only for Java classes
; (import '(java.io InputStream File))
;
; for clojure classes use require
; (require 'clojure.string)
; (require '[clojure.string :as str])
; (str/split . . .)
;
; namespece with ns at the top of your file
; (ns name & references)
; :import, :require, :use

; Java interop
; (new java.util.Random)
; (def rnd (new java.util.Random)
; (. rnd nextInt 10)
; (.nextInt rnd 10)

; 
; (javadoc javaclass)


; (def p (java.awt.Point. 10 20))
; (. p x) 
; -> 10
; (.x p)
; -> 10

; (. Math PI)

; (recur exprs*) ; recursion in a loop

(defn demo1 [n]
(loop [result [] x n]
 (if (zero? x)
   result
   (recur (conj result x) (dec x)))))

(defn demo2 [result n]
  (if (zero? n)
    result
    (recur (conj result n) (dec n))))

; (into [] (take n (iterate dec n)))
; (into [] (drop-last (reverse (range 6))))
; etc
; (def whole-numbers (iterate inc 1))
; (take 10 (filter odd? whole-numbers))

; map takes a source collection coll and a function f and returns
; a new seq by invoking f on each element in coll
; (map f coll)
; (map #(+ 1 %) (take 10 (filter odd? whole-numbers)))
; map can take more than one source coll if f takes mult args
; use %1 %2 etc

; (for [binding-form coll-expr filter-expr? ...] expr)
; (take 10 (for [n whole-numbers :when (even? n)] n ))
;  for [file "ABCDEFGH" rank (range 1 9)] (format "%c%d" file rank))

; java Reader provides a stream of characters
; use with-open
; (with-open [rdr (reader filename)] (count (line-seq rdr)))

; see other data structure specific functions in ref doc

; vectors are functions
; ([:a :b :c] 1)
; -> :b
; (assoc [1 2 3] 2 :two)
; -> [1 2 :two]

; display vector (def dvec ["." "X"])
; index seq (def fseq '(0 0 1 1 1))
; (println (map dvec fseq))
; -> (. . X X X)


; (keys map) (vals map)
; (get map key value-if-not-found?)
; you can leave out the get and put the map in the function name position
; at the start of a form
; (mapname :key)
; -> value

; build maps
; assoc returns map with a k/v added
; dissoc with key removed
; select-keys keeps only those specified
; merge combines maps

; letfn to create local fnc
; each fn in a letfn can call itself or any other fn in the same block

; comp to compose functions

; transformations transducers eductions

;graphics notes
; java.awt.Graphics is the base class for all graphics
;




