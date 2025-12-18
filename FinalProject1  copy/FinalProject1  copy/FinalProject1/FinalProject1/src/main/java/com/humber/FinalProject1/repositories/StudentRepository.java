package com.humber.FinalProject1.repositories;

import com.humber.FinalProject1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Custom query to find students by category and production year using native SQL
    @Query(value = "SELECT * FROM Student WHERE lower(contact) = lower(?1) AND GRADE = ?2", nativeQuery = true)
    List<Student> findByCategoryAndStudentGrade(String searchedContact, Integer searchedGrade);

    // Custom query to find students by class name
    @Query(value = "SELECT * FROM Student WHERE lower(class_name) = lower(?1)", nativeQuery = true)
    List<Student> findByClassName(String className);
}
