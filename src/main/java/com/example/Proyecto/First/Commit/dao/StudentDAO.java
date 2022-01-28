package com.example.Proyecto.First.Commit.dao;

import com.example.Proyecto.First.Commit.dto.Filter;
import com.example.Proyecto.First.Commit.dto.FilterPrueba;
import com.example.Proyecto.First.Commit.dto.StudentPage;
import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.entities.User;


import java.util.List;
import java.util.Set;

public interface StudentDAO {

    List<Student> findAll(User user);
    List<Student> findCity(String city, User user);
    List<Student> findCountry(String Country,  User user);
    List<Student> findSkills(Set<Skill> skills, User user);
    List<Student> findPresence(Presence presence, User user);
    List<Student> findTransfer(Boolean transfer, User user);
    List<Student> findAllFilter(Filter filter, User user);
    List<Student> findAllFilterPage(Filter filter, User user, Integer page, Integer perPage);
    List<Student> findKeyWord(String keyWord, User user);
    List<String > findCities(Long id);
    List<String> findCountries(Long id);
    Skill findSkill(String skill);




}
