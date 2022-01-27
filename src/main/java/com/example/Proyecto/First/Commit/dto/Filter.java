package com.example.Proyecto.First.Commit.dto;

import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;

import java.util.Set;

public class Filter {
    Set<String> skills;
    String country;
    String city;
    Presence presence;
    Boolean transfer;


    public Filter() {
    }

    public Filter(Set<String> skills, String country, String city, Presence presence, Boolean transfer) {
        this.skills = skills;
        this.country = country;
        this.city = city;
        this.presence = presence;
        this.transfer = transfer;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Presence getPresence() {
        return presence;
    }

    public Boolean getTransfer() {
        return transfer;
    }

    public void setSkills(Set<String> skills) {
        this.skills = skills;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPresence(Presence presence) {
        this.presence = presence;
    }

    public void setTransfer(Boolean transfer) {
        this.transfer = transfer;
    }
}
