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
        @JsonSubTypes.Type(value = CreateMessage.class, name = "CREATE")
})
public abstract class Message {
    protected String text;

    public Message() {};

    public Message(String text) { this.text = text; };


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
