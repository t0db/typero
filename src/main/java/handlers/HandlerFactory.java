package handlers;

import java.util.HashMap;
import java.util.Map;

import messages.JoinMessage;
import messages.Message;


public class HandlerFactory {
    private Map<String, MessageHandler> handlers;
    
    public HandlerFactory() {
        this.handlers = new HashMap<>();
        initialize();
    }
    
    public MessageHandler getHandler(Message message) {
        if (!handlers.containsKey(message.getClass().getSimpleName())) {
            throw new RuntimeException("Handler doesn't exist");
        }
        return handlers.get(message.getClass().getSimpleName());
    }

    private void initialize() {
        
    }
}
