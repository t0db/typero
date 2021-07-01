package messages;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = CreateMessage.class, name = "CREATE"),
    @JsonSubTypes.Type(value = CreatedMessage.class, name = "CREATED"),
    @JsonSubTypes.Type(value = JoinMessage.class, name = "JOIN"),
    @JsonSubTypes.Type(value = StartMessage.class, name = "START"),
    @JsonSubTypes.Type(value = WordMessage.class, name = "WORD"),
    @JsonSubTypes.Type(value = EndGameMessage.class, name = "END"),
    @JsonSubTypes.Type(value = StatsMessage.class, name = "STATS")
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
