const websocketMiddleware = () => {
  let socket = null;

  const onOpen = store => event => {
    console.log("CONNECTION OPENED.");
    console.log("STORE", store);
    console.log("EVENT", event);
  };

  const onClose = store => event => {
    console.log("CONNECTION CLOSED.");
    console.log("STORE", store);
    console.log("EVENT", event);
  };

  const onMessage = store => event => {
    console.log("MESSAGE RECEIVED");
    console.log("STORE", store);
    console.log("EVENT", event);
  };

  // eslint-disable-next-line no-unused-vars
  return store => next => action => {
    switch (action.type) {
      case "INIT_CONNECTION":
        socket = new WebSocket("ws://localhost:8080/typero/websocketendpoint");
        socket.onopen = onOpen(store);
        socket.onclose = onClose(store);
        socket.onmessage = onMessage(store);
        break;
      default:
        if (socket)
          socket.send(JSON.stringify(action));
    }
    next(action);
  };
};

export default websocketMiddleware();