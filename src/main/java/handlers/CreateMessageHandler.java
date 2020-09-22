package handlers;

import java.util.UUID;

import javax.websocket.Session;

import memory.InMemoryDatabase;
import messages.Message;
import models.Game;
import models.Player;

public class CreateMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Session session, Message message) {
        Game game = new Game();
        String uuid = UUID.randomUUID().toString();
        game.setUUID(uuid);
        game.addPlayer(new Player(session));
        InMemoryDatabase.games.put(uuid, game);
        game.updateState();
    }

}
