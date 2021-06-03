import React from "react";
import { useSelector } from "react-redux";

const Game = () => {
  const quote = useSelector(state => state.game.quote);
  return (
    <div>
      {quote}
    </div>
  );
};

export default Game;