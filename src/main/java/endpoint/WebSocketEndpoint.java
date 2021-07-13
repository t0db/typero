package endpoint;


import java.util.Set;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import coders.MessageDecoder;
import coders.MessageEncoder;
import handlers.HandlerFactory;
import handlers.MessageHandler;
import messages.Message;

@ServerEndpoint(
        value = "/websocketendpoint", 
        decoders = { MessageDecoder.class }, 
        encoders = { MessageEncoder.class }
)
public class WebSocketEndpoint {
    private static final Logger LOGGER = LogManager.getLogger(WebSocketEndpoint.class);
    
    private HandlerFactory handlerFactory = new HandlerFactory();

    @OnOpen
    public void onOpen(Session session) {
        LOGGER.debug("Socket successfully connected.");
    }

    @OnError
    public void onError(Session session, Throwable t) {
    	System.out.println("ERROR IS HERE");
    }

    @OnMessage
    public void message(Session session, Message message) {
        MessageHandler messageHandler = handlerFactory.getHandler(message);
        messageHandler.handleMessage(session, message);
    }
}
