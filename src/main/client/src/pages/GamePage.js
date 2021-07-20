/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { sendWord } from "../reducers/gameReducer";
import PropTypes from "prop-types";

const WordWrap = ({ word }) => {
  const highlight = {
    color: "#99cc99"
  };
  const underline = {
    textDecoration: "underline"
  };

  return (
    <span style=
      {
        Object.assign(
          word.isTyped ? highlight : {},
          word.isActive ? underline : {}
        )
      }
    >{word.value}</span>
  );
};
WordWrap.propTypes = {
  word: PropTypes.object.isRequired
};

const GamePage = () => {
  // converting string quote to word objects to track the changes
  const quoteString = useSelector(state => state.game.quote);
  const wordsArray = quoteString.split(" ");
  // const quoteArrayTest = ["this", "is", "just", "a", "test", "string"];
  const wordObjects =
    wordsArray
      .map((elem, idx) => {
        return {
          value: elem,
          isTyped: false,
          isActive: idx === 0 ? true : false
        };
      });
  const [words, setWords] = useState(wordObjects);
  const [typedWord, setTypedWord] = useState("");
  const [currentWordIndex, setCurrentWordIndex] = useState(0);
  const dispatch = useDispatch();

  const handleWord = e => {
    if (e.code === "Space") {
      checkWord();
      dispatch(sendWord(typedWord));
      setTypedWord("");
      e.target.value = "";
      e.preventDefault();
    }
  };
  const checkWord = () => {
    if (typedWord === words[currentWordIndex].value) {
      const wordsCopy = [...words];
      wordsCopy[currentWordIndex].isTyped = true;
      wordsCopy[currentWordIndex].isActive = false;
      if (words.length <= currentWordIndex) {
        wordsCopy[currentWordIndex+1].isActive = true;
      }
      setCurrentWordIndex(currentWordIndex + 1);
      setWords(wordsCopy);
    }
  };

  return (
    <div className="container game-container">
      <p>
        {
          words
            .map((elem, idx) =>
              <WordWrap key={idx} word={elem} />
            )
        }
      </p>
      <input
        type="text"
        onKeyDown={handleWord}
        onChange={e => setTypedWord(e.target.value)}
      />
    </div>
  );
};

export default GamePage;