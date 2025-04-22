package com.SECEProject.ELearningSystem.Repository;

import com.SECEProject.ELearningSystem.Entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByCourses_C_id(Integer c_id);
}