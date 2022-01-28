package com.example.Proyecto.First.Commit.service.student;

import com.example.Proyecto.First.Commit.dao.StudentDAO;
import com.example.Proyecto.First.Commit.dao.StudentDAOImpl;
import com.example.Proyecto.First.Commit.dto.StudentDTO;
import com.example.Proyecto.First.Commit.entities.Nivel;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.service.uploadfile.UploadFile;
import com.example.Proyecto.First.Commit.service.uploadfile.UploadFileImpl;

import java.util.HashSet;
import java.util.Set;

public class StudentServiceImpl implements StudentService{
    UploadFile uploadFile = new UploadFileImpl();
    StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentServiceImpl() {
    }

    @Override
    public boolean validateStudentCreate(StudentDTO student){
        if (student.getEmail()==null||student.getName()==null)
            return false;
        if (student.getPhoto()!=null)
            try {String photo = uploadFile.uploadImage(student.getPhoto());}
            catch (Exception e) { return false;}
        if (student.getDocument()!=null)
            try {String document = uploadFile.uploadPdf(student.getDocument());}
            catch (Exception e) { return false;}
        return true;
    }
    @Override
    public Student convertStudentCreate(StudentDTO student, Set<Skill> skills) throws Exception {


        Student studentTemp = new Student();
        studentTemp.setCity(student.getCity());
        studentTemp.setCountry(student.getCountry());
        studentTemp.setTransfer(student.getTransfer());
        studentTemp.setPresence(student.getPresence());
        studentTemp.setEmail(student.getEmail());
        studentTemp.setSkills(skills);
        studentTemp.setPhoneNumber(student.getPhoneNumber());
        studentTemp.setName(student.getName());
        if (student.getPhoto()!=null)
            studentTemp.setPhoto(uploadFile.uploadImage(student.getPhoto()));
        else studentTemp.setPhoto(null);
        if (student.getDocument()!=null)
            studentTemp.setDocument(uploadFile.uploadPdf(student.getDocument()));
        else studentTemp.setDocument(null);
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
    public Student convertStudentUpdate(StudentDTO studentNew, Student studentOld)  {
        Student studentTemp = studentOld;
        Set<Skill> skills = new HashSet<>();
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
        if (studentNew.getSkills()!=null){
            for (String skillNew: studentNew.getSkills()){
                Skill skill = new Skill();
                skill.setNivel(Nivel.JUNIOR);
                skill.setSkill(skillNew);
                skills.add(skill);
            }
            studentTemp.setSkills(skills);}
        if (studentNew.getName()!=null)
            studentTemp.setName(studentNew.getName());

        return studentTemp;
    }
}
