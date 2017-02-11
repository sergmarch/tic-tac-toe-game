(ns tic-tac-toe-game.utils)

(defn random-nums [[width _]]
  (-> width
      (* 2)
      range
      (as-> after-range
            (map inc after-range)
            (concat after-range after-range)
            (shuffle after-range)
            (map-indexed vector after-range))
      (into [])))
