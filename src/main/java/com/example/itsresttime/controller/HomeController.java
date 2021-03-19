package com.example.itsresttime.controller;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private StudentService service;

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student st = service.save(student);
        if (st != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(st);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Student byId = service.getStudentById(id);
        if (byId != null) {
            return ResponseEntity.status(HttpStatus.FOUND).body(byId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        try {
            List<Student> allStudents = service.getAllStudent();
            if (allStudents.size() > 0) {
                return ResponseEntity.status(HttpStatus.FOUND).body(allStudents);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        if (service.updateStudent(student) == 1) {
            return ResponseEntity.ok(student);
        } else if (service.updateStudent(student) == 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") int id) {
        if (service.deleteStudent(id)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
