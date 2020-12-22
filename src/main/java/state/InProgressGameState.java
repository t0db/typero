package state;

import messages.GameOverMessage;
import models.Game;
import models.Player;
import util.ResponseGenerator;

public class InProgressGameState implements GameState {
    
    private Game game;
    
    public InProgressGameState(Game game) {
        this.game = game;
    }
    
    @Override
    public void handle() {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        Player[] players = new Player[] { player1, player2 };
        
        if (player1.getIdxOfCurrentWord() == game.getQuote().length) {
            ResponseGenerator.broadcast(players, new GameOverMessage("Winner is player 1"));
        }
        if (player2.getIdxOfCurrentWord() == game.getQuote().length) {
            ResponseGenerator.broadcast(players, new GameOverMessage("Winner is player 2"));
        }
    }

}
