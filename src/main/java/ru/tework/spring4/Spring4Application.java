package ru.tework.spring4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ru.tework.spring4.controllers.StudentController;

@SpringBootApplication
public class Spring4Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring4Application.class, args);
		// System.out.println("start");
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// context.scan("ru.tework.spring4");
		// context.refresh();
		// StudentController studentController = context.getBean(StudentController.class);
		// studentController.getOne();
		// context.close();

	}

}
