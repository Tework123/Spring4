package ru.tework.spring4.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.tework.spring4.entities.Achievement;
import ru.tework.spring4.entities.Student;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {

    @Query(value = "SELECT * FROM achievement", nativeQuery = true)
    List<Achievement> findAll();
}
