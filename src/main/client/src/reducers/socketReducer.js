export const initializeConnection = () => ({
  type: "INIT_CONNECTION"
});

const socketReducer = (state = {}, action) => {
  switch (action.type) {
    case "INIT_CONNECTION":
      return new WebSocket("ws://localhost:8080/typero/websocketendpoint");
    default:
      return state;
  }
};

export default socketReducer;