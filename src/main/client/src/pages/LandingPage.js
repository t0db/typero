import React from "react";
import { useDispatch } from "react-redux";
import { createGame } from "../reducers/gameReducer";

const LandingPage = () => {
  const dispatch = useDispatch();

  return (
    <div>
      <input type="button" onClick={() => dispatch(createGame())} value="Create game" />
    </div>
  );
};

export default LandingPage;