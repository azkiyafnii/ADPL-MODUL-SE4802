package com.example.demo.model;

import com.example.demo.model.Course;
import java.util.List;

public class Student {
    private String nama;
    private String nim;
    private List<Course> courses;

    public Student() {}

    public Student(String nama, String nim, List<Course> courses) {
        this.nama = nama;
        this.nim = nim;
        this.courses = courses;
    }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public List<Course> getCourses() { return courses; }
    public void setCourses(List<Course> courses) { this.courses = courses; }
}