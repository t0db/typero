/* eslint-disable no-unused-vars */
import actionManager from "./actionManager";

const websocketMiddleware = () => {
  let socket = null;

  const onOpen = store => event => {
  };

  const onClose = store => event => {
  };

  const onMessage = store => event => {
    const action = JSON.parse(event.data);
    actionManager(store, action);
  };

  return store => next => action => {
    switch (action.type) {
      case "INIT_CONNECTION":
        socket = new WebSocket(`ws://${window.location.host}/typero/websocketendpoint`);
        socket.onopen = onOpen(store);
        socket.onclose = onClose(store);
        socket.onmessage = onMessage(store);
        break;
      case "CREATE":
      case "JOIN":
      case "WORD":
        socket.send(JSON.stringify(action));
    }
    next(action);
  };
};

export default websocketMiddleware();