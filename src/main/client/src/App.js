import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { Switch, Route } from "react-router-dom";

import HomePage from "./pages/HomePage";
import NewGamePage from "./pages/NewGamePage";
import GamePage from "./pages/GamePage";
import EndGamePage from "./pages/EndGamePage";

const initializeConnection = () => ({
  type: "INIT_CONNECTION"
});

const App = () => {
  const dispatch = useDispatch();
  useEffect(() => dispatch(initializeConnection()), []);

  return (
    <Switch>
      <Route exact path="/">
        <HomePage />
      </Route>
      <Route path="/newgame">
        <NewGamePage />
      </Route>
      <Route path="/game">
        <GamePage />
      </Route>
      <Route path="/endgame">
        <EndGamePage />
      </Route>
    </Switch>
  );
};

export default App;