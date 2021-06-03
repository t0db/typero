export const createGame = () => ({
  type: "CREATE"
});

export const joinGame = (gameid) => ({
  type: "JOIN",
  payload: gameid
});

const gameReducer = (state = {}, action) => {
  switch (action.type) {
    case "CREATED":
      return { ...state, gameId: action.data };
    case "START":
      return { ...state, quote: action.data };
    default:
      return state;
  }
};

export default gameReducer;