package com.example.itsresttime.repo;

import com.example.itsresttime.models.StuTeaRelation;
import com.example.itsresttime.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {

    List<Student> findByNameAndCourse(String name, String course);

    List<Student> findByNameOrCourse(String name, String course);

    List<Student> findByNameLike(String regex);

    List<Student> findByNameStartingWith(String regex);

    @Query("select new com.example.itsresttime.models.StuTeaRelation(t.name,s.course) from Teacher t JOIN t.students s")
    List<StuTeaRelation> getTeacherCourse();

}
