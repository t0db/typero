import React, { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { createGame } from "./reducers/gameReducer";

const initializeConnection = () => ({
  type: "INIT_CONNECTION"
});

const App = () => {
  const dispatch = useDispatch();
  useEffect(() => dispatch(initializeConnection()), []);
  const gameId = useSelector(state => state.game.gameId);

  return (
    <div>
      <input type="button" onClick={() => dispatch(createGame())} value="create" />
      <div>GAME ID: {gameId}</div>
    </div>
  );
};

export default App;