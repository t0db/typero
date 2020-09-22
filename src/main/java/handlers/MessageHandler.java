package handlers;

import javax.websocket.Session;

import messages.Message;

public interface MessageHandler {
    void handleMessage(Session session, Message message);
}
