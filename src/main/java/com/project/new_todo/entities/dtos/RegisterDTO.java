package com.project.new_todo.entities.dtos;

import com.project.new_todo.entities.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {}
