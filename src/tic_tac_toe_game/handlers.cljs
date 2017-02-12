(ns tic-tac-toe-game.handlers
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require
    [re-frame.core :refer [register-handler register-sub subscribe dispatch]]
    [tic-tac-toe-game.utils :as utils]))

(def board-size {:s [4 4] ;; default size
                 :m [6 4]
                 :l [8 4]})

(def board (into []
                 (repeat (reduce * (:s board-size))
                         nil)))

(def nums (utils/random-nums (:s board-size)))

(def initial-state {:board-size (:s board-size)
                    :board board
                    :nums nums
                    :game-running? true})


;; handlers
(register-handler
  :initialize
  (fn [db _]
    (merge db initial-state)))

(register-handler
  :show-num
  (fn [db [_ index]]
    (let [[[_ num]] (into [] (filter #(= index (first %)) (:nums db)))
          updated-board (into-array (:board db))]
      (do
        (aset updated-board index num)
        (assoc db :board (into [] updated-board))))))

;; subscriptions
(register-sub
  :board
  (fn [db _]
    (reaction (:board @db))))
