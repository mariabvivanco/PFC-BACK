package com.example.Proyecto.First.Commit.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String  skill;

    @JsonIgnore
    private  Nivel nivel;

    public Skill() {
    }

    public Skill(Long id, String skill, Nivel nivel) {
        this.id = id;
        this.skill = skill;
        this.nivel = nivel;
    }

    public Skill(String skill, Nivel nivel) {

        this.skill = skill;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }
}
