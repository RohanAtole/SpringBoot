package com.example.taskmanager.service.impl;

import com.example.taskmanager.dto.TaskRequestDTO;
import com.example.taskmanager.dto.TaskResponseDTO;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.service.TaskService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskResponseDTO createTask(TaskRequestDTO request) {

        Task task = TaskMapper.toEntity(request);

        Task savedTask = repository.save(task);

        return TaskMapper.toDTO(savedTask);
    }

    @Override
    public List<TaskResponseDTO> getAllTasks() {

        return repository.findAll()
                .stream()
                .map(TaskMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
    
    @Override
    public TaskResponseDTO updateTask(Long id, TaskRequestDTO request) {

        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());

        Task updatedTask = repository.save(task);

        return TaskMapper.toDTO(updatedTask);
    }
}