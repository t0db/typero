import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { createGame } from "./reducers/gameReducer";

const initializeConnection = () => ({
  type: "INIT_CONNECTION"
});

const App = () => {
  const dispatch = useDispatch();
  useEffect(() => dispatch(initializeConnection()), []);

  return (
    <div>
      <input type="button" onClick={() => dispatch(createGame())} value="create" />
    </div>
  );
};

export default App;