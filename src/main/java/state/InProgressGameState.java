package state;

import messages.EndGameMessage;
import messages.StatsMessage;
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
        
        if (player1.getIdxOfCurrentWord() == game.getQuote().length) {
            ResponseGenerator.sendPlayerMessage(player1, new EndGameMessage("You have won the game."));
            ResponseGenerator.sendPlayerMessage(player2, new EndGameMessage("You have lost the game."));
            processEndGame(player1);
            	
        }
        if (player2.getIdxOfCurrentWord() == game.getQuote().length) {
        	ResponseGenerator.sendPlayerMessage(player2, new EndGameMessage("You have won the game."));
            ResponseGenerator.sendPlayerMessage(player1, new EndGameMessage("You have lost the game."));
            processEndGame(player2);
        }
    }
    
    // word per minute calculation
	private void processEndGame(Player player) {
		long endGameTime = System.currentTimeMillis();
		long gameDurationInSeconds = (endGameTime - game.getStartTime()) / 1000;
		long numberOfWordsInQoute = game.getQuote().length;
		double wordsPerMinute = ((double)numberOfWordsInQoute / gameDurationInSeconds) * 60;
		ResponseGenerator.sendPlayerMessage(player, new StatsMessage("SPEED: " + (int)Math.floor(wordsPerMinute) + " WPM."));
	}

}
