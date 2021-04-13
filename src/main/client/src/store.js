import { createStore, applyMiddleware } from "redux";

import rootReducer from "./rootReducer";
import websocketMiddleware from "./websocketMiddleware";

const store = createStore(
  rootReducer,
  applyMiddleware(websocketMiddleware)
);

export default store;