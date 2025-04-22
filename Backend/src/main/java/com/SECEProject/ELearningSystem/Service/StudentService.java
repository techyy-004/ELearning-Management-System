package com.SECEProject.ELearningSystem.Service;

import com.SECEProject.ELearningSystem.Entity.Student;
import com.SECEProject.ELearningSystem.Entity.Course;
import com.SECEProject.ELearningSystem.Repository.StudentRepository;
import com.SECEProject.ELearningSystem.Repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student enrollStudentInCourse(Integer st_id, Integer c_id) {
        Student student = studentRepository.findById(st_id).orElseThrow(() -> new RuntimeException("Student not found."));
        Course course = courseRepository.findById(c_id).orElseThrow(() -> new RuntimeException("Course not found."));

        student.getCourses().add(course);
        return studentRepository.save(student);
    }

    public List<Student> getStudentsByCourseId(Integer c_id) {
        return studentRepository.findByCourses_C_id(c_id);
    }
    
    @Transactional
    public Optional<Student> getStudentById(Integer st_id) {
        return studentRepository.findById(st_id);
    }

    @Transactional
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Integer st_id, Student student) {
        student.setSt_id(st_id);
        studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Integer st_id) {
        studentRepository.deleteById(st_id);
    }
}