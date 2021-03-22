package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.repo.StudentDao;
import com.example.itsresttime.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentQueryController {

    @Autowired
    StudentServiceImpl service;

    @GetMapping("/student-by-name-and-course/{name}/{course}")
    public List<Student> getStudentByNamesAndCourse(@PathVariable("name") String name, @PathVariable("course") String course) {
        return service.findByNameAndCourse(name, course);
    }

    @GetMapping("/student-by-name-or-course/{name}/{course}")
    public List<Student> getStudentByNamesOrCourse(@PathVariable("name") String name, @PathVariable("course") String course) {
        return service.findByNameOrCourse(name, course);
    }

    @GetMapping("/student-by-name-like/{name}")
    public List<Student> getStudentByNamesLike(@PathVariable("name") String name) {
        return service.findByNameLike(name);
    }


    @GetMapping("/student-by-name-start/{name}")
    public List<Student> getStudentByNameStartWith(@PathVariable("name") String name) {
        return service.findByNameStartingWith(name);
    }


}
