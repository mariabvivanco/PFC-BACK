package com.example.Proyecto.First.Commit.dto;

import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


public class StudentPage {

    private Long id;
    private String name;
    private String country;
    private String city;
    private String phone_number;
    private String email;
    private Presence presence;
    private Boolean transfer;
    private String skill;
    private String photo;
    private String document;
    //private int total;

    public StudentPage() {
    }

    public StudentPage(Long id, String name, String country, String city, String phone_number, String email, Presence presence, Boolean transfer, String skill, String photo, String document) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.phone_number = phone_number;
        this.email = email;
        this.presence = presence;
        this.transfer = transfer;
        this.skill = skill;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
