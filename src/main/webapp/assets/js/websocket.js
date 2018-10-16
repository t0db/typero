var socket;

function initializeConnection() {
    
    const endpoint = "/echo";
    if (window.location.protocol === "http:") {
        socket = new WebSocket("ws://" + window.location.host + endpoint);
    } else {
        socket = new WebSocket("wss://" + window.location.host + endpoint);
    }

    socket.onopen = function(event) {
        console.log("WebSocket is open now.");
        socket.send("Message to be sent");
    };

    socket.onclose = function(event) {
        console.log("WebSocket is closed now.");
    };

    socket.onmessage = function(event) {
        console.log("WebSocket message received: ", event);
    };

    socket.onerror = function(event) {

    };
}

document.querySelector("#btn").addEventListener("click", function() {
    initializeConnection();
})
