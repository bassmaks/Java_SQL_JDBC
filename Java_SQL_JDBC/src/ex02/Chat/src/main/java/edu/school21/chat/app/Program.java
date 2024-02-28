package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.Instant;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        HikariDataSource dataSource;
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("    ");
        dataSource = new HikariDataSource(config);

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);

        User creator = new User(3L, "user", "user", new ArrayList<>(), new ArrayList<>());
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, new ArrayList<>());
        Message message = new Message(null, author, room, "Hello!", Instant.now().toString());

        messagesRepository.save(message);
        System.out.println(message.getId());
    }
}
