import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { Switch, Route } from "react-router-dom";

import HomePage from "./pages/HomePage";
import NewGamePage from "./pages/NewGamePage";
import GamePage from "./pages/GamePage";
import EndGamePage from "./pages/EndGamePage";
import "./index.css";

const initializeConnection = () => ({
  type: "INIT_CONNECTION"
});

const App = () => {
  const dispatch = useDispatch();
  useEffect(() => dispatch(initializeConnection()), []);

  return (
    <Switch>
      <Route exact path="/typero/">
        <HomePage />
      </Route>
      <Route path="/typero/newgame">
        <NewGamePage />
      </Route>
      <Route path="/typero/game">
        <GamePage />
      </Route>
      <Route path="/typero/endgame">
        <EndGamePage />
      </Route>
    </Switch>
  );
};

export default App;