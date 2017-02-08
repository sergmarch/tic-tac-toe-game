(ns tic-tac-toe-game.core
  (:require
    [reagent.core :as reagent]
    [re-frame.core :refer [dispatch-sync]]
    [tic-tac-toe-game.view :as view]
    [tic-tac-toe-game.handlers :as handlers]))

(defn run []
  (dispatch-sync [:initialize])
  (reagent/render [view/app]
                  (.getElementById js/document "app")))

(run)

