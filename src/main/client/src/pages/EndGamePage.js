import React from "react";
import { useSelector } from "react-redux";
import { useStore } from "react-redux";
import { push } from "react-router-redux";

const EndGamePage = () => {
  const message = useSelector(state => state.game.message);
  const stats = useSelector(state => state.game.stats);

  const store = useStore();
  const goHome = () => store.dispatch(push("/typero"));

  return (
    <div className="container stats-container">
      <div className="stats-wrapper">
        <p>{message}</p>
        <p>Words per minute: {stats}</p>
      </div>
      <input type="button" onClick={goHome} value="Home page" />
    </div>
  );
};

export default EndGamePage;