package handlers;


import java.util.List;

import javax.websocket.Session;

import database.InMemoryDatabase;
import messages.StartMessage;
import messages.WaitMessage;
import util.ResponseGenerator;

public class JoinMessageHandler implements MessageHandler {
    @Override
    public void handleMessage(Session s) {
        List<Session> players = InMemoryDatabase.players;
        players.add(s);
        if (players.size() == 2) {
            ResponseGenerator.broadcast(new StartMessage("Game is ready to start."));
        }
        else {
            ResponseGenerator.broadcast(new WaitMessage("Waiting for second player"));
        }
    }
    
    

}

