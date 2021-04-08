import React, { useEffect } from "react";
import { useDispatch } from "react-redux";
import { initializeConnection } from "./reducers/socketReducer";
import { createGame } from "./reducers/gameReducer";

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