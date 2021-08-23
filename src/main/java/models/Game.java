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
    private long startTime;
    private long endTime;
    
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
    
    public long getStartTime() {
    	return startTime;
    }
    
    public void setStartTime(long startTime) {
    	this.startTime = startTime;
    }
    
    public long getEndTime() {
    	return endTime;
    }
    
    public void setEndTime(long endTime) {
    	this.endTime = endTime;
    }
    
    // calculates words per minute for specified player
    public int calculateStats(Player player) {
		// -5 is for the delay at the beginning of the game
		long gameDurationInSeconds = (endTime - startTime) / 1000 - 5;
		// number of correctly typed words
		long words = player.getIdxOfCurrentWord();
		
		double wordsPerMinute = ((double) words / gameDurationInSeconds) * 60;
    	return (int) Math.floor(wordsPerMinute);
    }
    
}
