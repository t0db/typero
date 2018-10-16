package endpoint;

import data.DataCollection;

import javax.websocket.*;
import java.io.IOException;

@javax.websocket.server.ServerEndpoint("/echo")
public class ServerEndpoint {

    private Session session;

    @OnOpen
    public void open(Session session, EndpointConfig config) {
        System.out.println("Connection opened");
        this.session = session;
        DataCollection.sessions.add(session);
    }

    @OnClose
    public void close(Session session, CloseReason reason) {
        System.out.println("Connection closed: " + reason.getReasonPhrase());
        DataCollection.sessions.remove(session);
    }

    @OnMessage
    public void message(Session session, String message) {
        for (Session s : DataCollection.sessions) {
            try {
                s.getBasicRemote().sendText("Message from the server.");
            } catch (IOException e) {
                DataCollection.sessions.remove(s);
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void error(Session session, Throwable error) {
        System.out.println("Connection error");
    }
}
