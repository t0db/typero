/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import { useDispatch, } from "react-redux";
import { sendWord } from "../reducers/gameReducer";
import PropTypes from "prop-types";

const WordWrap = ({ word }) => {
  const highlight = {
    backgroundColor: "green"
  };
  return(
    <span style={word.isTyped ? highlight : {} }> {word.value} </span>
  );
};
WordWrap.propTypes = {
  word: PropTypes.object.isRequired
};

const GamePage = () => {
  // converting string quote to word objects to track the changes
  // const quote = useSelector(state => state.game.quote);
  // const quoteArray = quote.split(" ");
  const quoteArrayTest = ["this", "is", "just", "a", "test", "string"];
  const wordObjects = quoteArrayTest.map(elem => ({ value: elem, isTyped: false }));
  const [words, setWords] = useState(wordObjects);
  const [word, setWord] = useState("");
  const [currentWord, setCurrentWord] = useState(0);
  const dispatch = useDispatch();

  const handleWord = e => {
    if (e.code === "Space") {
      checkWord();
      dispatch(sendWord(word));
      setWord("");
      e.target.value = "";
      e.preventDefault();
    }
  };
  const checkWord = () => {
    if (word === words[currentWord].value) {
      const wordsCopy = [...words];
      wordsCopy[currentWord].isTyped = true;
      setCurrentWord(currentWord + 1);
      setWords(wordsCopy);
    }
  };

  return (
    <div>
      <p>
        {words
          .map((elem, idx) =>
            <WordWrap key={idx} word={elem} />)
        }
      </p>
      <input type="text" onKeyDown={handleWord} onChange={e => setWord(e.target.value)} />
    </div>
  );
};

export default GamePage;