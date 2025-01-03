package ru.tework.spring4.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class StudentController {

    private ApplicationContext context;

    public void context(ApplicationContext context) {
        this.context = context;
    }

    public void getOne() {
        StudentController studentController = context.getBean(StudentController.class);
		studentController.getOne();
        System.out.println("Hello GeeksForGeeks");

    }

}
