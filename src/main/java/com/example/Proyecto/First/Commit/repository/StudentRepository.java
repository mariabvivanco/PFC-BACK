package com.example.Proyecto.First.Commit.repository;

import com.example.Proyecto.First.Commit.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
