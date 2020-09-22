package memory;

import java.util.HashMap;
import java.util.Map;

import models.Game;

public class InMemoryDatabase {
    public static Map<String, Game> games = new HashMap<>();
}
