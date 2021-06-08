import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { sendWord } from "../reducers/gameReducer";

const Game = () => {
  const quote = useSelector(state => state.game.quote);
  const [word, setWord] = useState("");
  const dispatch = useDispatch();

  const handleWord = e => {
    if (e.code === "Space") {
      dispatch(sendWord(word));
      setWord("");
      e.target.value = "";
      e.preventDefault();
    }
  };

  return (
    <div>
      <p>{quote}</p>
      <input type="text" onKeyDown={handleWord} onChange={e => setWord(e.target.value)} />
    </div>
  );
};

export default Game;