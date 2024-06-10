package com.TaskManagement;

import com.TaskManagement.model.Task;
import com.TaskManagement.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(TaskRepository taskRepository) {
        return args -> {
            taskRepository.save(new Task("Task 1", "Description for Task 1", LocalDate.now().plusDays(1), false));
            taskRepository.save(new Task("Task 2", "Description for Task 2", LocalDate.now().plusDays(2), false));
            taskRepository.save(new Task("Task 3", "Description for Task 3", LocalDate.now().plusDays(3), false));
            taskRepository.save(new Task("Task 4", "Description for Task 3", LocalDate.now().plusDays(6), false));
            taskRepository.save(new Task("Task 5", "Description for Task 3", LocalDate.now().plusDays(12), false));
            taskRepository.save(new Task("Task 6", "Description for Task 3", LocalDate.now().plusDays(7), false));
        };
    }
}
