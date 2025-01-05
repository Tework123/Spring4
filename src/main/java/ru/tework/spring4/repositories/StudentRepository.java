package ru.tework.spring4.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import jakarta.persistence.QueryHint;
import ru.tework.spring4.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT student.id , student.name, achievement.id, achievement.bonus FROM student INNER JOIN student_achievement ON student.id = student_achievement.student_id INNER JOIN achievement ON student_achievement.achievement_id = achievement.id", nativeQuery = true)
    List<Student> findAll();
}
