package ru.tework.spring4.controllers;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityManager;
import ru.tework.spring4.entities.Achievement;
import ru.tework.spring4.entities.Student;
import ru.tework.spring4.repositories.AchievementRepository;
import ru.tework.spring4.repositories.StudentRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    private AchievementRepository achievementRepository;

    public StudentController(StudentRepository studentRepository,
            AchievementRepository achievementRepository) {
        this.studentRepository = studentRepository;
        this.achievementRepository = achievementRepository;
    }

    @GetMapping("/student")
    public String getMethodName() {
        List<Student> list = studentRepository.findAll();
        for (Student student : list) {
            System.out.println(student);
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getAchievements());
            System.out.println("###############");

        }
        // studentRepository.deleteById(list.getFirst().getId());

        return "123";
    }

    @GetMapping("/achievements")
    public String getMethodName2() {
        List<Achievement> list = achievementRepository.findAll();
        for (Achievement achievement : list) {
            System.out.println(achievement.getId());
            System.out.println(achievement.getStudents());
            System.out.println(achievement);
            System.out.println("###############");

        }
        return "123";
    }

}
