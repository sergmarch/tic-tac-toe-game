(ns tic-tac-toe-game.view
  (:require
    [re-frame.core :refer [dispatch]]
    [tic-tac-toe-game.handlers :as handlers]))

(defn render-scene [{:keys [s]} board]
  (into [:div.board]
        (let [[width height] s
              board-indexed (map-indexed vector board)
              items (->> board-indexed
                         (map (fn [[index val]]
                                (into [:div.board__block
                                       {:on-click #(dispatch [:show-num index])}]
                                      val))))]
          (.log js/console board-indexed)
          (map #(into [:div.board__row] %)
               (partition width items)))))

(defn app []
  [:div
   [render-scene handlers/board-size handlers/board]])