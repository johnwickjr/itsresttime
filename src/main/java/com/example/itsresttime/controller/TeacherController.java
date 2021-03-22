package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.models.Teacher;
import com.example.itsresttime.service.TeacherDao;
import com.example.itsresttime.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService service;

    @GetMapping("/teacher")
    public Teacher getTeacher() {
        Student student = new Student("student 1", "email of student1", "s1 course");
        Student student2 = new Student("student 2", "email of student2", "s2 course");
        Student student3 = new Student("student 3", "email of student3", "s3 course");
        Teacher teacher = new Teacher("teacher 1", Arrays.asList(student, student2, student3));
        service.save(teacher);
        return teacher;
    }

//
//    @GetMapping("/teachers")
//    public List<Teacher> getTeachers() {
//
//    }

}
