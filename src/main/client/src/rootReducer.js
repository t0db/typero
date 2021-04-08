import { combineReducers } from "redux";
import gameReducer from "./reducers/gameReducer";
import socketReducer from "./reducers/socketReducer";

const rootReducer = combineReducers({
  socket: socketReducer,
  game: gameReducer
});

export default rootReducer;