package handlers;

import javax.websocket.Session;

import memory.InMemoryDatabase;
import messages.Message;
import models.Game;
import models.Player;

public class JoinMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Session session, Message message) {
        String gameId = message.getText();
        Game game = InMemoryDatabase.games.get(gameId);
        game.addPlayer(new Player(session));
        game.updateState();
    }

}
