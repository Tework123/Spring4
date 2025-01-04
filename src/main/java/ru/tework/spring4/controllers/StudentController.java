package ru.tework.spring4.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import ru.tework.spring4.entities.Student;
import ru.tework.spring4.repositories.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/student")
    public String getMethodName() {
        List<Student> list = studentRepository.findAll();
        System.out.println(list);
        return "123";
    }

    public void getOne() {

    }

}
