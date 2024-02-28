package edu.school21.chat.models;

public class Message {
    private Long id;
    private User author;
    private Chatroom room;
    private String messageText;
    private String dateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (!id.equals(message.id)) return false;
        if (!author.equals(message.author)) return false;
        if (!room.equals(message.room)) return false;
        if (!messageText.equals(message.messageText)) return false;
        return dateTime.equals(message.dateTime);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + messageText.hashCode();
        result = 31 * result + dateTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", author=" + author +
                ", room=" + room +
                ", messageText='" + messageText + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
