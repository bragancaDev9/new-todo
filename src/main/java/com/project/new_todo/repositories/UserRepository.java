package com.project.new_todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.new_todo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	UserDetails findByLogin(String login);
}
