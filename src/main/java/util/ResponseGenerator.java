package util;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.Session;

import messages.Message;
import models.Player;

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
    
    public static void sendPlayerMessage(Player player, Message message) {
    	sendMessage(player.getSession(), message);
    }
    
    public static void broadcast(Player[] players, Message message) {
        for (Player player : players) {
            sendPlayerMessage(player, message);
        }
    }
}
