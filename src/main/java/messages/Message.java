package messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "MessageType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = WaitMessage.class, name = "WAIT"),
        @JsonSubTypes.Type(value = JoinMessage.class, name = "JOIN"),
        @JsonSubTypes.Type(value = StartMessage.class, name = "START"),
        @JsonSubTypes.Type(value = CreateMessage.class, name = "CREATE"),
        @JsonSubTypes.Type(value = WordMessage.class, name = "WORD")
        
})
public abstract class Message {
    protected String payload;

    public Message() {};

    public Message(String payload) { this.payload = payload; };


    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
