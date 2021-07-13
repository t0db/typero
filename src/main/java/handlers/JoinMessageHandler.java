package handlers;

import javax.websocket.Session;

import memory.InMemoryDatabase;
import messages.ErrorMessage;
import messages.Message;
import models.Game;
import models.Player;
import util.ResponseGenerator;

public class JoinMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Session session, Message message) {
        String gameId = message.getPayload();
        Game game = InMemoryDatabase.games.get(gameId);
        if (game == null) {
        	ResponseGenerator.sendMessage(session, new ErrorMessage("Game with entered id doesn't exist"));
        }
        else {
        	game.addPlayer(new Player(session));
        	InMemoryDatabase.gameForSession.put(session.getId(), gameId);
        	game.updateState();
        }
    }

}
