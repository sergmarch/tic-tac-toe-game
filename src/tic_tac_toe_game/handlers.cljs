(ns tic-tac-toe-game.handlers
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require
    [re-frame.core :refer [register-handler register-sub subscribe dispatch]]))

(def board-size {:s [4 4] ;; default size
                 :m [6 4]
                 :l [8 4]})

(def initial-state {:board-size (:s board-size)
                    :game-running? true})


;; handlers
(register-handler
  :initialize
  (fn [db _]
    (merge db initial-state)))