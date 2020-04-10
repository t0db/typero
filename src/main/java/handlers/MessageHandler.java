package handlers;

import javax.websocket.Session;

public interface MessageHandler {
    void handleMessage(Session s);
}
