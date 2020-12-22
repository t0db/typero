var obj = {};

obj.initializeConnection = function() {

    const endpoint = "/typero/websocketendpoint";
    if (window.location.protocol === "http:") {
        obj.socket = new WebSocket("ws://" + window.location.host + endpoint);
    } else {
        obj.socket = new WebSocket("wss://" + window.location.host + endpoint);
    }

    obj.socket.onopen = function(event) {
        console.log("WebSocket is open now.");
    };

    obj.socket.onclose = function(event) {
        console.log("WebSocket is closed now.");
    };

    obj.socket.onmessage = function(event) {
        console.log("WebSocket message received: ", event);
    };

    obj.socket.onerror = function(event) {
    };
}
obj.initializeConnection();

document.querySelector("#create").addEventListener("click", function() {
    obj.socket.send(JSON.stringify({"MessageType": "CREATE", "payload": "Create game"}));
})
document.querySelector("#join").addEventListener("click", function() {
	var textInput = document.querySelector("#inputBox").value;
	obj.socket.send(JSON.stringify({"MessageType": "JOIN", "payload": textInput}));
})
document.querySelector("#word").addEventListener("click", () => {
    var textInput = document.querySelector("#wordBox").value;
    obj.socket.send(JSON.stringify({"MessageType": "WORD", "payload": textInput}));
})