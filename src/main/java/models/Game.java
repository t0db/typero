package models;


import state.GameState;
import state.InPreparationGameState;

public class Game {
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
