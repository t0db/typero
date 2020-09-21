package state;

import models.Game;

public class InProgressGameState implements GameState {
    
    private Game game;
    
    public InProgressGameState(Game game) {
        this.game = game;
    }
    
    @Override
    public void handle() {
        
    }

}
