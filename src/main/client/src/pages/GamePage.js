import React, { useEffect, useState } from "react";
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

const ModalCounter = ({ counter }) => {
  return (
    <div className="modal-container">
      <div className="modal-content">
        Get ready: {counter}
      </div>
    </div>
  );
};
ModalCounter.propTypes = {
  counter: PropTypes.number.isRequired
};

const GamePage = () => {
  // converting string quote to word objects to track the changes
  const backupString = "Backup string to prevent crashing during testing.";
  const quoteString = useSelector(state => state.game.quote) || backupString;
  const wordsArray = quoteString.split(" ");
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

  const [showModal, setShowModal] = useState(true);
  const [counter, setCounter] = useState(5);
  const updateCounter = () => {
    if (counter > 0) {
      setCounter(counter - 1);
    }
    else {
      setShowModal(false);
    }
  };
  useEffect(
    () => {
      const id = setTimeout(() => {
        updateCounter();
      }, 1000);
      return () => clearTimeout(id);
    },
    [counter]
  );

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
        wordsCopy[currentWordIndex + 1].isActive = true;
      }
      setCurrentWordIndex(currentWordIndex + 1);
      setWords(wordsCopy);
    }
  };

  return (
    <div className="container game-container">
      {showModal && <ModalCounter counter={counter} />}
      <div className="quote-container">
        {
          words
            .map((elem, idx) =>
              <WordWrap key={idx} word={elem} />
            )
        }
      </div>
      <input
        type="text"
        onKeyDown={handleWord}
        onChange={e => setTypedWord(e.target.value)}
        autoFocus={true}
      />
    </div>
  );
};

export default GamePage;