package com.example.Proyecto.First.Commit.security.service.student;

import com.example.Proyecto.First.Commit.dto.StudentDTO;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.security.service.uploadfile.UploadFile;

public class StudentServiceImpl implements StudentService {

    UploadFile uploadFile;

    @Override
    public boolean validateStudentCreate(StudentDTO student){
        if (student.getEmail()==null||student.getName()==null)
            return false;
        try {String photo = uploadFile.uploadImage(student.getPhoto());}
        catch (Exception e) { return false;}
        try {String photo = uploadFile.uploadPdf(student.getDocument());}
        catch (Exception e) { return false;}
        return true;
    }
    @Override
    public Student convertStudentCreate(StudentDTO student) throws Exception {
        Student studentTemp = new Student();
        studentTemp.setCity(student.getCity());
        studentTemp.setCountry(student.getCountry());
        studentTemp.setTransfer(student.getTransfer());
        studentTemp.setPresence(student.getPresence());
        studentTemp.setEmail(student.getEmail());
        studentTemp.setSkills(student.getSkills());
        studentTemp.setPhoneNumber(student.getPhoneNumber());
        studentTemp.setName(student.getName());
        studentTemp.setPhoto(uploadFile.uploadImage(student.getPhoto()));
        studentTemp.setDocument(uploadFile.uploadPdf(student.getDocument()));
        return studentTemp;
    }

    @Override
    public boolean validateStudentUpdate(StudentDTO student){
        if (student.getEmail()==null||student.getName()==null)
            return false;
        try {String photo = uploadFile.uploadImage(student.getPhoto());}
        catch (Exception e) { return false;}
        try {String photo = uploadFile.uploadPdf(student.getDocument());}
        catch (Exception e) { return false;}
        return true;
    }

    @Override
    public Student convertStudentUpdate(StudentDTO studentNew, Student studentOld) throws Exception {
        Student studentTemp = studentOld;
        if (studentNew.getCity()!=null)
            studentTemp.setCity(studentNew.getCity());
        if (studentNew.getCountry()!=null)
            studentTemp.setCountry(studentNew.getCountry());
        if (studentNew.getTransfer()!=null)
            studentTemp.setTransfer(studentNew.getTransfer());
        if (studentNew.getPhoneNumber()!=null)
            studentTemp.setPhoneNumber(studentNew.getPhoneNumber());
        if (studentNew.getPresence()!=null)
            studentTemp.setPresence(studentNew.getPresence());
        if (studentNew.getEmail()!=null)
            studentTemp.setEmail(studentNew.getEmail());
        if (studentNew.getSkills()!=null)
            studentTemp.setSkills(studentNew.getSkills());
        if (studentNew.getName()!=null)
            studentTemp.setName(studentNew.getName());
        if (studentNew.getPhoto()!=null)
            studentTemp.setPhoto(uploadFile.uploadImage(studentNew.getPhoto()));
        if (studentNew.getDocument()!=null)
            studentTemp.setDocument(uploadFile.uploadPdf(studentNew.getDocument()));
        return studentTemp;
    }
}
