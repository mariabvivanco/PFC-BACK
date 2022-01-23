package com.example.Proyecto.First.Commit.dto;

import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

    private Long id;
    private String name;
    private String country;
    private String city;
    private String phoneNumber;
    private String email;
    private Presence presence;
    private Boolean transfer;
    private Set<String> skills = new HashSet<String>();
    private MultipartFile photo;
    private MultipartFile document;

    public StudentDTO(Long id, String name, String country, String city, String phoneNumber, String email, Presence presence,
                      Boolean transfer, Set<String> skills, MultipartFile photo, MultipartFile document) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.presence = presence;
        this.transfer = transfer;
        this.skills = skills;
        this.photo = photo;
        this.document = document;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Presence getPresence() {
        return presence;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public Boolean getTransfer() {
        return transfer;
    }

    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public MultipartFile getPhoto() {
        return photo;
    }

    public void setPhoto(MultipartFile photo) {
        this.photo = photo;
    }

    public MultipartFile getDocument() {
        return document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }
}
