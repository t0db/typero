export const createGame = () => ({
  type: "CREATE"
});

const gameReducer = (state = {}, action) => {
  switch (action.type) {
    case "CREATE": {
      console.log(state);
      return state;
    }
    case "CREATED": {
      console.log("ACTION", action);
      return { ...state, gameId: action.payload };
    }
    default:
      return state;
  }
};

export default gameReducer;