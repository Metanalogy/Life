
;namespace etc setup


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


; display vector (def dvec ["." "X"])
; index seq (def fseq '(0 0 1 1 1))
; (println (map dvec fseq))
; -> (. . X X X)

(def dvec ["." "X"])
(def sizeL 10) ; size of pool
;(def a (range sizeL))
(def indx (for [x (range sizeL) y (range sizeL)] [x y]))
