package com.example.Proyecto.First.Commit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="fc_user")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique = true,  nullable = false, length = 50)
    private String email;


    @Column(nullable = false)
    @JsonIgnore
    private String password;

    @Column(length = 15)
    private String phone;

    @Column
    private String name;


    @Column
    private String code;



    public User() {
    }

    public User(long id, String email, String password, String phone, String name) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;

    }

    public User(String email, String password, String phone, String name) {

        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;

    }

    public User(String email, String username, String password) {
        this.email = email;
        //this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

/* public User addStudent(Student student){
        Set<Student> studentsTemp = this.getStudents();
        if (studentsTemp.contains(student))
            return null;
        else{
            studentsTemp.add(student);
            this.setStudents(studentsTemp);
            return this;
        }
    }*/
}
