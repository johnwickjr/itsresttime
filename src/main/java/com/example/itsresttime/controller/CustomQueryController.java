package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.models.Teacher;
import com.example.itsresttime.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class CustomQueryController {

    @Autowired
    TeacherService service;


    @PostMapping("teacher-save")
    public Teacher saveTeacher() {
        Teacher teacher = new Teacher("tagteacher");

        Student student = new Student("ratan", "ratan@gmial.com", "spring boot");
        Student student2 = new Student("rohan", "tagrohan@gmail.com", "spring boot");
        Student student3 = new Student("sattu", "raftaar@gmail.com", "angular");

        teacher.setStudents(Arrays.asList(student, student3, student2));

        student.setTeachers(teacher);
        student2.setTeachers(teacher);
        student3.setTeachers(teacher);

        service.save(teacher);
        return teacher;
    }

    @GetMapping("/teacher-name/{name}")
    public Teacher getStudentByName(@PathVariable("name") String name) {
        return service.getTeacherByName(name);
    }

    @GetMapping("/find-by-name/{name}")
    public Teacher findByName(@PathVariable("name") String name) {
        return service.getTeacherByName(name);
    }
}
