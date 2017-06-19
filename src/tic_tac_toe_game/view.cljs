(ns tic-tac-toe-game.view
  (:require
    [re-frame.core :refer [dispatch subscribe]]
    [tic-tac-toe-game.handlers :as handlers]))

;; super test

(defn render-scene [{:keys [s]} board]
  (into [:div.board]
        (let [[width height] s
              updated-board (subscribe [:board])
              board-indexed (map-indexed vector @updated-board)
              items (->> board-indexed
                         (map (fn [[index val]]
                                (into [:div.board__block
                                       {:on-click #(dispatch [:show-num index])}]
                                      (str val)))))]
          (map #(into [:div.board__row] %)
               (partition width items)))))

(defn app []
  [:div
   [render-scene handlers/board-size handlers/board]])
