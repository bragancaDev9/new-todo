package com.project.new_todo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.new_todo.entities.Task;
import com.project.new_todo.repositories.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	// Create
	
	// Read
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	// Update
	
	// Delete
}
