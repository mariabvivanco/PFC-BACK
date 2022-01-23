package com.example.Proyecto.First.Commit.service.student;

import com.example.Proyecto.First.Commit.dto.StudentDTO;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;

import java.util.Set;

public interface StudentService {
    boolean validateStudentCreate(StudentDTO student);
    Student convertStudentCreate(StudentDTO student, Set<Skill> skills) throws Exception;
    boolean validateStudentUpdate(StudentDTO student);
    Student convertStudentUpdate(StudentDTO studentNew, Student studentOld) throws Exception;

}
