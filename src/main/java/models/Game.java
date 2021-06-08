package models;


import java.util.StringJoiner;

import state.GameState;
import state.InPreparationGameState;

public class Game {
    private String uuid;
    private GameState gameState;
    private Player player1;
    private Player player2;
    private String[] quote;
            
    public Game() {
        quote = new String[] { "string", "to", "guess" };
        gameState = new InPreparationGameState(this);
    }
    
    public void updateState() {
        gameState.handle();
    }
    
    public void changeState(GameState newGameState) {
        this.gameState = newGameState;
    }
    
    public String getUUID() {
        return uuid;
    }
    
    public void setUUID(String uuid) {
        this.uuid = uuid;
    }
    
    public String[] getQuote() {
        return quote;
    }
    
    public String getQuoteString() {
    	StringJoiner joiner = new StringJoiner(" ");
    	for (String word : quote) {
			joiner.add(word);
		}
    	return joiner.toString();
    }
    
    public Player getPlayer(String sessionId) {
        if (player1.getSession().getId().equals(sessionId))
            return player1;
        return player2;
    }
    
    public Player getPlayer1() {
        return player1;
    }
    
    public Player getPlayer2() {
        return player2;
    }
    
    public void addPlayer(Player player) {
        if (player1 == null) {
            player1 = player;
        } else if (player2 == null) {
            player2 = player;
        }
    }
    
}
