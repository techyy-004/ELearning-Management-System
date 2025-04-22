package com.SECEProject.ELearningSystem.Service;

import com.SECEProject.ELearningSystem.Entity.Course;
import com.SECEProject.ELearningSystem.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Integer c_id) {
        return courseRepository.findById(c_id).orElse(null);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer c_id, Course updatedCourse) {
        return courseRepository.findById(c_id).map(course -> {
            course.setC_type(updatedCourse.getC_type());
            course.setC_name(updatedCourse.getC_name());
            course.setC_description(updatedCourse.getC_description());
            course.setC_year(updatedCourse.getC_year());
            course.setYoutube_url(updatedCourse.getYoutube_url());
            course.setWebsite_url(updatedCourse.getWebsite_url());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found with ID: " + c_id));
    }

    public void deleteCourse(Integer c_id) {
        if (courseRepository.existsById(c_id)) {
            courseRepository.deleteById(c_id);
        } else {
            throw new RuntimeException("Course not found with ID: " + c_id);
        }
    }
}