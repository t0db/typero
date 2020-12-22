package memory;

import java.util.HashMap;
import java.util.Map;

import models.Game;

public class InMemoryDatabase {
    public static Map<String, Game> games = new HashMap<>();
    
    // Key: sessionId
    // Value: gameId of the game that session is a part of
    public static Map<String, String> gameForSession = new HashMap<>();
}
