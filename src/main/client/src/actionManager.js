import { push } from "react-router-redux";

const actionManager = (store, action) => {
  switch (action.type) {
    case "CREATED":
      store.dispatch({ type: "CREATED", data: action.payload });
      store.dispatch(push("/typero/newgame"));
      break;
    case "START":
      store.dispatch({ type: "START", data: action.payload });
      store.dispatch(push("/typero/game"));
      break;
    case "END":
      store.dispatch({ type: "END", data: action.payload });
      store.dispatch(push("/typero/endgame"));
      break;
    case "STATS":
      store.dispatch({ type: "STATS", data: action.payload });
      break;
  }
};

export default actionManager;