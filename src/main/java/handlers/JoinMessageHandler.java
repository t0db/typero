package handlers;

import javax.websocket.Session;

import memory.InMemoryDatabase;
import messages.Message;
import models.Game;
import models.Player;

public class JoinMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Session session, Message message) {
        String gameId = message.getPayload();
        System.out.println("GAME ID" + gameId);
        Game game = InMemoryDatabase.games.get(gameId);
        game.addPlayer(new Player(session));
        InMemoryDatabase.gameForSession.put(session.getId(), gameId);
        game.updateState();
    }

}
