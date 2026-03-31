package com.project.new_todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.new_todo.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {}
