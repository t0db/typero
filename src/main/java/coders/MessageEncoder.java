package coders;

import messages.Message;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageEncoder implements Encoder.Text<Message> {
    private ObjectMapper objectMapper;
    
    public MessageEncoder() {
        objectMapper = new ObjectMapper();
    }
    
    @Override
    public String encode(Message message) throws EncodeException {
        String JSON = null;
        try {
             JSON = objectMapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return JSON;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
