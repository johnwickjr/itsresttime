package com.example.itsresttime.service;

import com.example.itsresttime.models.Student;
import com.example.itsresttime.repo.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;

    @Override
    public Student save(Student student) {
        try {
            return dao.save(student);
        } catch (Exception e) {
            return null;
        }
    }

    public Student getStudentById(int id) {
        Optional<Student> student = dao.findById(id);
        return student.orElse(null);
    }

    public List<Student> getAllStudent() {
        return dao.findAll();
    }

    @Override
    public int updateStudent(Student student) {
        int code = -1;
        if (getUserIfExist(student.getId()) != null) code = 1;
        else code = 0;
        dao.save(student);
        return code;
    }


    public boolean deleteStudent(int id) {
        Student student = getUserIfExist(id);
        if (student != null) {
            dao.delete(student);
            return true;
        }
        return false;
    }


    public Student getUserIfExist(int id) {
        Optional<Student> student = dao.findById(id);
        return student.orElse(null);
    }

}
