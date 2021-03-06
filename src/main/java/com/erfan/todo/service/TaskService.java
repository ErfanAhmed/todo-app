package com.erfan.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.erfan.todo.domain.Task;
import com.erfan.todo.domain.User;
import com.erfan.todo.repository.TaskRepository;

import java.util.List;

/**
 * @author erfan
 * @since 4/16/21
 */
@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getAllTasks(User user) {
        return taskRepository.getAllByUser(user);
    }

    public Task getById(int id) {
        return taskRepository.findById(id)
                .orElse(null);
    }

    @Transactional
    public void delete(Task task) {
        taskRepository.delete(task);
    }
}
