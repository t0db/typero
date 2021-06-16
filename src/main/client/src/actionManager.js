import { push } from "react-router-redux";

const actionManager = (store, action) => {
  switch (action.type) {
    case "CREATED":
      store.dispatch({ type: "CREATED", data: action.payload });
      store.dispatch(push("/newgame"));
      break;
    case "START":
      store.dispatch({ type: "START", data: action.payload });
      store.dispatch(push("/game"));
      break;
    case "END":
      store.dispatch({ type: "END", data: action.payload });
      store.dispatch(push("/endgame"));
      break;
  }
};

export default actionManager;