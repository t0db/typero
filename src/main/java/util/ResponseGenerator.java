package util;

import java.io.IOException;

import javax.websocket.EncodeException;

import messages.Message;
import models.Player;

public class ResponseGenerator {
    public static void sendMessage(Player player, Message message) {
        try {
            player.getSession().getBasicRemote().sendObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EncodeException e) {
            e.printStackTrace();
        }
    }
    
    public static void broadcast(Player[] players, Message message) {
        for (Player player : players) {
            sendMessage(player, message);
        }
    }
}
