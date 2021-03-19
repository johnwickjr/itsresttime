package com.example.itsresttime.repo;

import com.example.itsresttime.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
}
