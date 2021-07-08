export const createGame = () => ({
  type: "CREATE"
});

export const joinGame = gameid => ({
  type: "JOIN",
  payload: gameid
});

export const sendWord = word => ({
  type: "WORD",
  payload: word
});

const gameReducer = (state = {}, action) => {
  switch (action.type) {
    case "CREATED":
      return { ...state, gameId: action.data };
    case "START":
      return { ...state, quote: action.data };
    case "END":
      return { ...state, message: action.data };
    case "STATS":
      return { ...state, stats: action.data };
    default:
      return state;
  }
};

export default gameReducer;