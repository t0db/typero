package state;

import messages.StartMessage;
import messages.WaitMessage;
import models.Game;
import models.Player;
import util.ResponseGenerator;

public class InPreparationGameState implements GameState {
    private Game game;
    
    public InPreparationGameState(Game game) {
        this.game = game;
    }
    
    @Override
    public void handle() {
        if (game.getPlayer1() != null && game.getPlayer2() != null) {
            game.changeState(new InProgressGameState(game));
            Player[] players = new Player[] { game.getPlayer1(), game.getPlayer2() };
            ResponseGenerator.broadcast(players, new StartMessage());
        } else {
            ResponseGenerator.sendMessage(game.getPlayer1(), new WaitMessage());
        }
    }

}
