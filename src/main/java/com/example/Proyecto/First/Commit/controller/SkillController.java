package com.example.Proyecto.First.Commit.controller;

import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    private final Logger log = LoggerFactory.getLogger(SkillController.class);
    private SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }



    @GetMapping("/all")
    public List<Skill> getAllSkill() {
        if (skillRepository == null) {
            return null;
        }
        return skillRepository.findAll();
    }

    @PostMapping("create")
    public ResponseEntity<Skill> createSkill(@RequestBody Skill skill) {

        if (skillRepository == null) {
            skillRepository.save(skill);
            return ResponseEntity.ok(skill);
        }

        if (skill.getId() != null) {

            Optional optSkill = skillRepository.findById(skill.getId());
            if (optSkill.isPresent()) {
                log.warn("trying to update a skill that exist");
                return ResponseEntity.badRequest().build();
            }
        } else {
            skillRepository.save(skill);
            return ResponseEntity.ok(skill);
        }
        return ResponseEntity.ok(skill);
    }


   @PutMapping("{id}")
    public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill skill){
       Optional optSkill = skillRepository.findById(id);

       if (optSkill.isPresent()) {
           skill.setId(id);
           skillRepository.save(skill);
           return  ResponseEntity.ok(skill);
       }else {
           log.warn("trying to update a skill that does not exist");
           return ResponseEntity.notFound().build();
       }
   }

    @DeleteMapping("all")
    public ResponseEntity<?> deleteAllSkill() {

        skillRepository.deleteAll();
        log.warn("all skills were deleted ");
        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Skill> deleteSkillId(@PathVariable Long id) {

        Optional<Skill> optSkill = skillRepository.findById(id);
        if (optSkill.isPresent()) {
            skillRepository.delete(optSkill.get());
            return ResponseEntity.noContent().build();
        } else {
            log.warn("trying to delete a skill that does not exist");
            return ResponseEntity.badRequest().build();
        }
    }


}
