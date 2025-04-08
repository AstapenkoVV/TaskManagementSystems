package com.example.tms;

import com.example.tms.model.Author;
import com.example.tms.model.Task;
import com.example.tms.repository.AuthorRepository;
import com.example.tms.repository.TaskRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class TmsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TmsApplication.class, args);

		AuthorRepository authorRepository = context.getBean(AuthorRepository.class);
		for (int i = 1; i <=3 ; i++) {
			Author author = new Author();

			author.setAuthorId((long) i);
			author.setAuthorName("author " + i);
			authorRepository.create(author);
		}

		TaskRepository taskRepository = context.getBean(TaskRepository.class);
		for (int i = 1; i <= 10; i++) {
			Task task = new Task();

			task.setTaskId((long) i);
			task.setTaskName("Task " + i);
			task.setDescription("description " + i);
			task.setStatus("completed " + i);
			task.setPriority("normal " + i);
			task.setComment("comment " + i);
			task.setAuthorId(ThreadLocalRandom.current().nextLong(1, 4));
			task.setExecutor("executor " + i);

			taskRepository.create(task);
		}
	}

}

