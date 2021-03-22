package com.example.itsresttime.service;

import com.example.itsresttime.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface TeacherDao extends JpaRepository<Teacher, Integer> {

    @Query("select t from Teacher t where t.name =:name")
    Teacher getTeacherByName(@Param("name") String name);


    Teacher findByName(String name);


}
