package com.example.Proyecto.First.Commit.security.service.student;

import com.example.Proyecto.First.Commit.dto.StudentDTO;
import com.example.Proyecto.First.Commit.entities.Student;

public interface StudentService {

    boolean validateStudentCreate(StudentDTO student);
    Student convertStudentCreate(StudentDTO student) throws Exception;
    boolean validateStudentUpdate(StudentDTO student);
    Student convertStudentUpdate(StudentDTO studentNew, Student studentOld) throws Exception;
}
