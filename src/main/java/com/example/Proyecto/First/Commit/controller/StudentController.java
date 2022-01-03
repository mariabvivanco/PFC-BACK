package com.example.Proyecto.First.Commit.controller;

import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.security.jwt.JwtRequestFilter;
import io.jsonwebtoken.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(StudentController.class);
    private SkillRepository skillRepository;
    private StudentRepository studentRepository;

    public StudentController(SkillRepository skillRepository, StudentRepository studentRepository) {
        this.skillRepository = skillRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/all")
    public List<Student> getAllStudent() {
           return studentRepository.findAll();
    }

    @GetMapping("/city/{nameCity}")
    public List<Student> getStudentByCity(@PathVariable String nameCity) {
        return studentRepository.findAll();
    }

    @GetMapping("/presence/{typePresence}")
    public List<Student> getStudentByPresence(@PathVariable Presence typePresence) {
        return studentRepository.findAll();
    }

    @GetMapping("/country/{nameCountry}")
    public List<Student> getStudentByCountry(@PathVariable String nameCountry) {
        return studentRepository.findAll();
    }

    @GetMapping("/transfer/typePresence}")
    public List<Student> getStudentByTransfery(@PathVariable Boolean typeTransfer) {
        return studentRepository.findAll();
    }

    @GetMapping("/skills")
    public List<Student> getStudentBySkylls(@RequestBody Set<Skill> skills) {
        return studentRepository.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<Student> createStudent( @RequestBody Student student) {



        if (student.getId() != null) {

            //TODO validar datos de entrada

            Optional optStudent = skillRepository.findById(student.getId());
            if (optStudent.isPresent()) {
                log.warn("trying to create a student that exist");
                return ResponseEntity.badRequest().build();
            }
        } else {
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent( @PathVariable Long id, @RequestBody Student student) {

        Optional optStudent = studentRepository.findById(id);

        if (optStudent.isPresent()) {
            student.setId(id);
            studentRepository.save(student);
            return  ResponseEntity.ok(student);
        }else {
            log.warn("trying to update a student that does not exist");
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllStudent() {

        studentRepository.deleteAll();
        log.warn("all students were deleted ");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Skill> deleteStudentlId(@PathVariable Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            studentRepository.delete(optionalStudent.get());
            return ResponseEntity.noContent().build();
        } else {
            log.warn("trying to delete a student that does not exist");
            return ResponseEntity.badRequest().build();
        }
    }




}
