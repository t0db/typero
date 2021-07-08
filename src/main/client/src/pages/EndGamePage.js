import React from "react";
import { useSelector } from "react-redux";

const EndGamePage = () => {
  const message = useSelector(state => state.game.message);
  const stats = useSelector(state => state.game.stats);
  return (
    <div>
      <p>{message}</p>
      <p>Words per minute: {stats}</p>
    </div>
  );
};

export default EndGamePage;