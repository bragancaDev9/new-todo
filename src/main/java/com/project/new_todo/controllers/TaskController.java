package com.project.new_todo.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.new_todo.entities.Task;
import com.project.new_todo.entities.dtos.TaskRequestDTO;
import com.project.new_todo.entities.dtos.TaskResponseDTO;
import com.project.new_todo.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	// Create
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody TaskRequestDTO taskDTO) {
		Task task = taskDTO.toTask(taskDTO);
		taskService.insert(task);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(task.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	// Read
	@GetMapping
	public ResponseEntity<List<TaskResponseDTO>> findAll() {
		List<Task> tasks = taskService.findAll();
		List<TaskResponseDTO> tasksDTO = tasks.stream()
				.map(TaskResponseDTO::new)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(tasksDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TaskResponseDTO> findById(@PathVariable Long id) {
		Task task = taskService.findById(id);
		TaskResponseDTO taskDTO = new TaskResponseDTO(task);
		
		return ResponseEntity.ok(taskDTO);
	}
	
	// Update
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody TaskRequestDTO taskDTO, @PathVariable Long id) {
		Task task = taskDTO.toTask(taskDTO);
		task.setId(id);
		task = taskService.update(task);
		return ResponseEntity.noContent().build();
	}
	
	// Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		taskService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
