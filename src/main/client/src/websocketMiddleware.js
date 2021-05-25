import actionManager from "./actionManager";

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
    console.log("DATA", event.data);
    console.log(store);
    const action = JSON.parse(event.data);
    actionManager(store, action);
  };

  return store => next => action => {
    switch (action.type) {
      case "INIT_CONNECTION":
        socket = new WebSocket("ws://localhost:8080/typero/websocketendpoint");
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