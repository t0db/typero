package endpoint;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ServerEndpoint("/test")
public class WebSocketEndpoint {
    private static final Logger LOGGER = LogManager.getLogger(WebSocketEndpoint.class);
    private static List<Session> players = new ArrayList<>();

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.debug("Session successfully created.");
        players.add(session);
        if (players.size() == 2) {
            broadcast("Game is starting.");
        } else {
            broadcast("Waiting for second player");
        }
    }

    private void broadcast(String message) {
        for (Session session : players) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnMessage
    public void message(Session session, String msg) {
        try {
            for (Session sess : session.getOpenSessions()) {
                if (sess.isOpen()) {
                    sess.getBasicRemote().sendText(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
