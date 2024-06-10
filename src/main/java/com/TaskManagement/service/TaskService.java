package com.TaskManagement.service;

import com.TaskManagement.model.Task;
import com.TaskManagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public record TaskService(TaskRepository taskRepository, GoogleCalendarService googleCalendarService) {

    @Autowired
    public TaskService {
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        Task savedTask = taskRepository.save(task);
        LocalDate dueDate = savedTask.getDueDate();
        LocalDateTime dueDateTime = dueDate.atTime(10,00);
        try {
            googleCalendarService.addEventToCalendar(savedTask.getTitle(), savedTask.getDescription(),dueDateTime);
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return savedTask;
    }


    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

}


