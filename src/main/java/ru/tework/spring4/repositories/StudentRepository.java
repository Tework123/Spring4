package ru.tework.spring4.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.tework.spring4.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT * FROM Student", nativeQuery = true)
    List<Student> findAll();
}
