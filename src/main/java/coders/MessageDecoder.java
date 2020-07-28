package coders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import messages.Message;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;


public class MessageDecoder implements Decoder.Text<Message> {
    private ObjectMapper objectMapper;
    
    public MessageDecoder() {
        objectMapper = new ObjectMapper();
    }
    
    @Override
    public Message decode(String s) throws DecodeException {
        try {
            return objectMapper.readValue(s, Message.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new DecodeException(s, "Cannot decode to any message type.");
        }
        
    }

    @Override
    public boolean willDecode(String s) {
        return s != null && !s.isEmpty();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
