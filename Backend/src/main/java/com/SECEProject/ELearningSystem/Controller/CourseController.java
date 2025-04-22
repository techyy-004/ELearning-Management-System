package com.SECEProject.ELearningSystem.Controller;

import com.SECEProject.ELearningSystem.Entity.Course;
import com.SECEProject.ELearningSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{c_id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer c_id) {
        Course course = courseService.getCourseById(c_id);
        return course != null ? ResponseEntity.ok(course) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) {
        Course savedCourse = courseService.addCourse(course);
        return ResponseEntity.ok(savedCourse);
    }

    @PutMapping("/{c_id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Integer c_id,
            @RequestBody Course updatedCourse) {

        Course course = courseService.updateCourse(c_id, updatedCourse);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/{c_id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer c_id) {
        courseService.deleteCourse(c_id);
        return ResponseEntity.noContent().build();
    }
}