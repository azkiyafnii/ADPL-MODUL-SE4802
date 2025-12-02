package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private RestTemplate restTemplate;

    private List<Student> studentList = new ArrayList<>();

    @PostConstruct
    public void init() {
        Course[] allCourses = restTemplate.getForObject("http://localhost:8083/courses/", Course[].class);

        if (allCourses != null && allCourses.length >= 2) {
            List<Course> andiCourses = Arrays.asList(allCourses[0]);
            List<Course> budiCourses = Arrays.asList(allCourses[1]);
            List<Course> citraCourses = Arrays.asList(allCourses);

            Student s1 = new Student("Andi", "123", andiCourses);
            Student s2 = new Student("Budi", "456", budiCourses);
            Student s3 = new Student("Citra", "789", citraCourses);

            studentList.add(s1);
            studentList.add(s2);
            studentList.add(s3);
        }
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentList;
    }

    @GetMapping("/{nim}")
    public Student getStudentByNim(@PathVariable String nim) {
        for (Student s : studentList) {
            if (s.getNim().equals(nim)) {
                return s;
            }
        }
        return null;
    }
}
