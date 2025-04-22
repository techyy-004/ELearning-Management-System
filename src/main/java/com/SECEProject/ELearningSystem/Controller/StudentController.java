package com.SECEProject.ELearningSystem.Controller;

import com.SECEProject.ELearningSystem.Entity.Student;
import com.SECEProject.ELearningSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public String createStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student created successfully!";
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{st_id}")
    public Optional<Student> getStudent(@PathVariable Integer st_id) {
        return studentService.getStudentById(st_id);
    }

    @PutMapping("/{st_id}")
    public String updateStudent(@PathVariable Integer st_id, @RequestBody Student student) {
        studentService.updateStudent(st_id, student);
        return "Student updated successfully!";
    }

    @DeleteMapping("/{st_id}")
    public String deleteStudent(@PathVariable Integer st_id) {
        studentService.deleteStudent(st_id);
        return "Student deleted successfully!";
    }
}