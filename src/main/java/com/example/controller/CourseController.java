package com.example.controller;

import com.example.model.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public List<Course> viewHomePage() {
        return courseService.getAllCourses();
    }

    @GetMapping("/add")
    public String showNewCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "new_course";
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course) {
        Course savedCourse = courseService.saveCourse(course);
        return savedCourse;
    }

    @DeleteMapping("/delete/{id}")  // Changed from GetMapping to DeleteMapping
    public void deleteCourse(@PathVariable long id) {
        courseService.deleteCourseById(id);
    }
}
