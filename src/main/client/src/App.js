import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { Switch, Route } from "react-router-dom";

import GamePage from "./pages/GamePage";
import NewGamePage from "./pages/NewGamePage";
import HomePage from "./pages/HomePage";


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
    </Switch>
  );
};

export default App;