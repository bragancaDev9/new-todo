package com.project.new_todo.entities.dtos;

import com.project.new_todo.entities.Task;

public class TaskRequestDTO {
	private String title;
	private String description;
	
	public TaskRequestDTO () {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	};

	public Task toTask(TaskRequestDTO taskDTO) {
		Task task = new Task();
		task.setTitle(taskDTO.getTitle());
		task.setDescription(taskDTO.getDescription());
		
		return task;
	}
}
