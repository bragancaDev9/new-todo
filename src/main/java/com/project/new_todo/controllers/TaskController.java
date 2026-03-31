package com.project.new_todo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.new_todo.entities.Task;
import com.project.new_todo.entities.dtos.TaskResponseDTO;
import com.project.new_todo.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	// Create

	// Read
	@GetMapping
	public ResponseEntity<List<TaskResponseDTO>> findAll() {
		List<Task> tasks = taskService.findAll();
		
		List<TaskResponseDTO> tasksDTO = tasks.stream()
				.map(TaskResponseDTO::new)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(tasksDTO);
	}
	
	// Update
	
	// Delete
}
