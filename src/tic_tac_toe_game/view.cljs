(ns tic-tac-toe-game.view
  (:require
    [tic-tac-toe-game.handlers :as handlers]))

(defn render-scene [{:keys [s]}]
  (into [:div.board]
        (let [[width height] s
              horizontal-items (range width)
              vertical-items (range height)]
          (for [v-item vertical-items]
            [:div.board__row
             (for [h-item horizontal-items]
               [:div.board__block {:key h-item}])]))))

(defn app []
  [:div
   [render-scene handlers/board-size]])