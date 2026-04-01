package com.project.new_todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.new_todo.entities.Task;
import com.project.new_todo.repositories.TaskRepository;
import com.project.new_todo.services.exceptions.ObjectNotFoundException;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	// Create
	public void insert(Task task) {
		taskRepository.save(task);
	}
	
	// Read
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Task findById(Long id) {
		return taskRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found. Id: " + id));
	}
	
	// Update
	
	// Delete
}
