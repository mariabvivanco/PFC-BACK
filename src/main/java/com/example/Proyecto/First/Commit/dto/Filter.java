package com.example.Proyecto.First.Commit.dto;

import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;

import java.util.Set;

public class Filter {
    Set<Skill> skills;
    String country;
    String city;
    Presence presence;
    Boolean transfer;

    public Filter(Set<Skill> skills, String country, String city, Presence presence, Boolean transfer) {
        this.skills = skills;
        this.country = country;
        this.city = city;
        this.presence = presence;
        this.transfer = transfer;
    }

    public Set<Skill> getSkills() {
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
}
