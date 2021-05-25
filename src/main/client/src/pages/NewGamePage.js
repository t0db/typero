import React from "react";
import { useSelector } from "react-redux";

const NewGamePage = () => {
  const gameId = useSelector(state => state.game.gameId);

  const copyToClipboard = () => navigator.clipboard.writeText(gameId);

  return (
    <div>
      <label htmlFor="gameid">Share this code to a friend you want to play with</label>
      <p>{gameId}</p>
      <input type="button" onClick={copyToClipboard} value="Copy code!" />
    </div>
  );
};

export default NewGamePage;