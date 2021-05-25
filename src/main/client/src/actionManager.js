import { push } from "react-router-redux";

const actionManager = (store, action) => {
  switch (action.type) {
    case "CREATED":
      console.log("ACTION MENADZUJEM");
      store.dispatch({ type: "CREATED", data: action.payload });
      store.dispatch(push("/newgame"));
  }
};

export default actionManager;