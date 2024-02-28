package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;

public class Program {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        HikariDataSource dataSource;
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("    ");
        dataSource = new HikariDataSource(config);

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
        Optional<Message> messageOptional = messagesRepository.findById(5L);
        if (messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message.setMessageText("ABOBAAAAA!");
            message.setDateTime(null);
            messagesRepository.update(message);
        }

        System.out.println(messagesRepository.findById(5L));
    }
}
