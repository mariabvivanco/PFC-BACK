package com.example.Proyecto.First.Commit.dao;


import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.entities.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * JPA
 * Hibernate
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    private Session session; // Hibernate

    @PersistenceContext
    private EntityManager entityManager; // JPA

    public StudentDAOImpl(Session session){
        this.session = session;
    }

    @Override
    public List<Student> findAll(User user) {
        long start = System.currentTimeMillis();
        Query<Student> query = session.createQuery("from Student where user = :user", Student.class);
        query.setParameter("user", user);
        List<Student> students = query.list();
        long end = System.currentTimeMillis();
        //System.out.println("Tiempo total findAll(): " + (end - start) + " ms");
        return students;
    }

    @Override
    public List<Student> findCity(String city, User user){
        Query<Student> query = session.createQuery("from Student where user = :user and city = :city", Student.class);
        query.setParameter("user", user);
        query.setParameter("city", city);
        List<Student> students = query.list();
        return students;
    }

    @Override
    public List<Student> findCountry(String country,  User user){
        Query<Student> query = session.createQuery("from Student where user = :user and country = :country", Student.class);
        query.setParameter("user", user);
        query.setParameter("country", country);
        List<Student> students = query.list();
        return students;
    }
    @Override
    public List<Student> findSkills(Set<Skill> skills, User user){
        Query<Student> query = session.createQuery("from Student where user = :user", Student.class);
        query.setParameter("user", user);
        List<Student> students = query.list();
        List<Student> studentsFind = new ArrayList();

        for (Student student:students){

            int countFound=0;
            for (Skill skillToFound: skills){
                for (Skill skillToCompare: student.getSkills()){
                    if (skillToCompare.getSkill().equalsIgnoreCase(skillToFound.getSkill()))
                        countFound++;


                }


            }
            if (countFound==skills.size())
                studentsFind.add(student);
            countFound=0;
        }
        return studentsFind;
    }
    @Override
    public List<Student> findPresence(Presence presence, User user){
        Query<Student> query = session.createQuery("from Student where user = :user and presence = :presence", Student.class);
        query.setParameter("user", user);
        query.setParameter("presence", presence);
        List<Student> students = query.list();
        return students;
    }
    @Override
    public List<Student> findTransfer(Boolean transfer, User user){
        Query<Student> query = session.createQuery("from Student where user = :user and transfer = :transfer", Student.class);
        query.setParameter("user", user);
        query.setParameter("transfer", transfer);
        List<Student> students = query.list();
        return students;
    }


}
