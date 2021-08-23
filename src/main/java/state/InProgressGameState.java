package state;

import messages.EndGameMessage;
import messages.StatsMessage;
import models.Game;
import util.ResponseGenerator;

public class InProgressGameState implements GameState {
    
    private Game game;
    
    public InProgressGameState(Game game) {
        this.game = game;
    }
    
    @Override
    public void handle() {
        if (game.getPlayer1().getIdxOfCurrentWord() == game.getQuote().length) {
            ResponseGenerator.sendPlayerMessage(game.getPlayer1(), new EndGameMessage("You have won the game."));
            ResponseGenerator.sendPlayerMessage(game.getPlayer2(), new EndGameMessage("You have lost the game."));
            processEndGame();
        }
        else if (game.getPlayer2().getIdxOfCurrentWord() == game.getQuote().length) {
        	ResponseGenerator.sendPlayerMessage(game.getPlayer1(), new EndGameMessage("You have lost the game."));
        	ResponseGenerator.sendPlayerMessage(game.getPlayer2(), new EndGameMessage("You have won the game."));
            processEndGame();
        }
    }
    
	private void processEndGame() {
		game.setEndTime(System.currentTimeMillis());
		
		int p1Stats = game.calculateStats(game.getPlayer1());
        ResponseGenerator.sendPlayerMessage(game.getPlayer1(), new StatsMessage(String.valueOf(p1Stats)));
        
        int p2Stats = game.calculateStats(game.getPlayer2());
        ResponseGenerator.sendPlayerMessage(game.getPlayer2(), new StatsMessage(String.valueOf(p2Stats)));
	}

}
