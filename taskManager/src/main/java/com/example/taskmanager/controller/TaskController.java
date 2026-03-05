package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskRequestDTO;
import com.example.taskmanager.dto.TaskResponseDTO;
import com.example.taskmanager.service.TaskService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO request) {
        return service.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDTO> getTasks() {
        return service.getAllTasks();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
    
    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable Long id,@RequestBody TaskRequestDTO request) {
    	return service.updateTask(id, request);
    }
}