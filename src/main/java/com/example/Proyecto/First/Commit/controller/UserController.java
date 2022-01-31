package com.example.Proyecto.First.Commit.controller;


import com.example.Proyecto.First.Commit.dto.ChangePasswordDTO;
import com.example.Proyecto.First.Commit.dto.VerifyCodeDTO;
import com.example.Proyecto.First.Commit.entities.User;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import com.example.Proyecto.First.Commit.service.login.SendEmail;
import com.example.Proyecto.First.Commit.service.login.SendEmailImpl;
import com.sparkpost.exception.SparkPostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

        private final Logger log = LoggerFactory.getLogger(UserController.class);
        private SkillRepository skillRepository;
        private StudentRepository studentRepository;
        private UserRepository userRepository;

        private PasswordEncoder encoder;

        public UserController(SkillRepository skillRepository, StudentRepository studentRepository, UserRepository userRepository,PasswordEncoder encoder ) {
            this.skillRepository = skillRepository;
            this.studentRepository = studentRepository;
            this.userRepository = userRepository;
            this.encoder = encoder;
        }



        @GetMapping("/all")
        public List<User> getAllStudent() {
            return userRepository.findAll();
        }


        @PostMapping("/forgPassword")
         public ResponseEntity<String> forgPassword(@RequestBody ChangePasswordDTO changePasswordDTO) throws SparkPostException {

            Optional<User> user = userRepository.findByemail(changePasswordDTO.getEmail());
            if (user.isPresent()) {
                String code = String.valueOf(Math.random() * 100000).substring(0, 5);
                user.get().setCode(code);
                userRepository.save(user.get());
                SendEmail sendEmail = new SendEmailImpl();

                sendEmail.sendEmail(code, user.get().getEmail());
                return ResponseEntity.ok("ok");
            }else
                return ResponseEntity.badRequest().build();

        }

        @PostMapping("/verifyCode")
        public ResponseEntity<String> verifyCode(@RequestBody VerifyCodeDTO verifyCodeDTO)  {

            Optional<User> optionalUser = userRepository.findByemail(verifyCodeDTO.getEmail());
            if ((verifyCodeDTO.getCode()!="")&&(optionalUser.isPresent())) {
                if (optionalUser.get().getCode().equals(verifyCodeDTO.getCode())){
                    optionalUser.get().setCode("ok");
                    userRepository.save(optionalUser.get());
                    return ResponseEntity.ok("ok");
                }
            }
            return ResponseEntity.noContent().build();

        }

    @PostMapping("/changePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO)  {

        Optional<User> optionalUser = userRepository.findByemail(changePasswordDTO.getEmail());
        if ((optionalUser.isPresent())&&(optionalUser.get().getCode().equals("ok"))) {
            String newpassword = encoder.encode(changePasswordDTO.getPassword());
            optionalUser.get().setCode("");
            optionalUser.get().setPassword(newpassword);
            userRepository.save(optionalUser.get());
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.badRequest().build();
    }
}
