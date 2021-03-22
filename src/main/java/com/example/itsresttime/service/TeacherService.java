package com.example.itsresttime.service;

import com.example.itsresttime.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;

    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    public Teacher getTeacherByName(String name) {
        return teacherDao.getTeacherByName(name);
    }

    public Teacher findByName(String name) {
        return teacherDao.getTeacherByName(name);
    }
}
