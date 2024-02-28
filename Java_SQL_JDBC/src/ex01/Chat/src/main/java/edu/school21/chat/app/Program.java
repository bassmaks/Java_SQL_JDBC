package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        HikariDataSource dataSource;
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        config.setUsername("postgres");
        config.setPassword("    ");
        dataSource = new HikariDataSource(config);

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);

        Long id = getIdFromDialog();
        Optional<Message> message = messagesRepository.findById(id);
        if(message.isPresent()) {
            System.out.println(message.get());
        } else {
            System.out.println("Message with id=" + id + " not found!");
        }
    }

    public static Long getIdFromDialog() {
        System.out.println("Enter a message ID");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }
}
