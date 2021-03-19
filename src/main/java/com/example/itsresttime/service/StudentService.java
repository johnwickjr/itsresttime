package com.example.itsresttime.service;

import com.example.itsresttime.models.Student;

import java.util.List;


public interface StudentService {
    Student save(Student student);

    public Student getStudentById(int id);

    public List<Student> getAllStudent();


    int updateStudent(Student student);

    public boolean deleteStudent(int id);
}
