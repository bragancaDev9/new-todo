package com.project.new_todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewTodoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(NewTodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		Task t1 = new Task(null, "title", "description");
		Task t2 = new Task(null, "title-1", "description-1");
		Task t3 = new Task(null, "title-2", "description-2");

		taskRepository.saveAll(Arrays.asList(t1, t2, t3));
		*/
	}
}
