package com.example.demo.controller;

import com.example.demo.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping("/")
    public List<Course> getCourses() {
        return Arrays.asList(
            new Course("IF101", "Algoritma Pemrograman", "Pak Budi"),
            new Course("IF102", "PBO", "Bu Sari")
        );
    }
}
