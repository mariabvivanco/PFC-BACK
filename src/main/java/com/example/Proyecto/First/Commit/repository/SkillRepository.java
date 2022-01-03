package com.example.Proyecto.First.Commit.repository;

import com.example.Proyecto.First.Commit.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
