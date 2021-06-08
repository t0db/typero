package handlers;

import javax.websocket.Session;

import memory.InMemoryDatabase;
import messages.Message;
import models.Game;
import models.Player;

public class WordMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Session session, Message message) {
        String gameId = InMemoryDatabase.gameForSession.get(session.getId());
        Game game = InMemoryDatabase.games.get(gameId);
        Player player = game.getPlayer(session.getId());
        
        String word = message.getPayload();
        String[] quote = game.getQuote();
        if (quote[player.getIdxOfCurrentWord()].equals(word)) {
            player.setNextWord();
            game.updateState();
        }
    }
   

}
