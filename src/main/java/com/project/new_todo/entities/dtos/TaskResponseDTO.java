package com.project.new_todo.entities.dtos;

import com.project.new_todo.entities.Task;

public class TaskResponseDTO {
	private String title;
	private String description;
	
	public TaskResponseDTO() {}
	
	public TaskResponseDTO(Task task) {
		title = task.getTitle();
		description = task.getDescription();
	}

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
	}
}
