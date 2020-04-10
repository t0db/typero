package util;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import database.InMemoryDatabase;
import messages.Message;

public class ResponseGenerator {
    public static void sendMessage(Session session, Message message) {
        try {
            session.getBasicRemote().sendObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
    
    public static void broadcast(Message message) {
        for (Session player : InMemoryDatabase.players) {
            sendMessage(player, message);
        }
    }
}
