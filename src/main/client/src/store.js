import { createStore, applyMiddleware } from "redux";
import { createBrowserHistory } from "history";
import { routerMiddleware } from "react-router-redux";

import rootReducer from "./rootReducer";
import websocketMiddleware from "./websocketMiddleware";

export const myHistory = createBrowserHistory();
const myRouterMiddleware = routerMiddleware(myHistory);


const store = createStore(
  rootReducer,
  applyMiddleware(websocketMiddleware, myRouterMiddleware)
);

export default store;