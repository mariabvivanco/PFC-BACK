package com.example.Proyecto.First.Commit.controller;


import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.entities.User;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

        private final Logger log = LoggerFactory.getLogger(UserController.class);
        private SkillRepository skillRepository;
        private StudentRepository studentRepository;
        private UserRepository userRepository;

        public UserController(SkillRepository skillRepository, StudentRepository studentRepository, UserRepository userRepository) {
            this.skillRepository = skillRepository;
            this.studentRepository = studentRepository;
            this.userRepository = userRepository;
        }

        @GetMapping("/all")
        public List<User> getAllStudent() {
            return userRepository.findAll();
        }




}
