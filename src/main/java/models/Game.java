package models;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players;
    private String[] quote;
            
    public Game() {
        players = new HashMap<>();
        quote = new String[] { "string", "to", "guess" };
    }
    
    public Map<String, Player> getPlayers() {
        return players;
    }
    
    public void addPlayer(Player newPlayer) {
        players.put(newPlayer.getSession().getId(), newPlayer);
    }
}
