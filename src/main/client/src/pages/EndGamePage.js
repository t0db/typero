import React from "react";
import { useSelector } from "react-redux";

const EndGamePage = () => {
  const endGameMessage = useSelector(state => state.endGameMessage);
  return (
    <div>{endGameMessage}</div>
  );
};

export default EndGamePage;