export const createGame = () => ({
  type: "CREATE"
});

const gameReducer = (state = {}, action) => {
  switch (action.type) {
    case "CREATE": {
      console.log(state);
      return state;
    }
    default:
      return state;
  }
};

export default gameReducer;