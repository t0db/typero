import React from "react";
import { useSelector } from "react-redux";

const EndGamePage = () => {
  const message = useSelector(state => state.game.message);
  const stats = useSelector(state => state.game.stats);
  return (
    <div className="container stats-container">
      <div className="stats-wrapper">
        <p>{message}</p>
        <p>Words per minute: {stats}</p>
      </div>

    </div>
  );
};

export default EndGamePage;