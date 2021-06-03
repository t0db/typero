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
  }
};

export default actionManager;