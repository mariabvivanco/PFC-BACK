package com.example.Proyecto.First.Commit.dao;


import com.example.Proyecto.First.Commit.dto.Filter;
import com.example.Proyecto.First.Commit.entities.*;
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
    public Skill findSkill(String skill){
        Query<Skill> query = session.createQuery("from Skill where skill = :skill and nivel = :nivel", Skill.class);
        query.setParameter("skill", skill);
        query.setParameter("nivel", Nivel.JUNIOR);
        Skill skillFound = query.getSingleResult();
        return skillFound;
    }

    @Override
    public List<Student> findAll(User user) {
        long start = System.currentTimeMillis();
        Query<Student> query = session.createQuery("from Student where user = :user", Student.class);
        query.setParameter("user", user);
        List<Student> students = query.list();
        long end = System.currentTimeMillis();
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


    @Override
    public List<Student> findAllFilter(Filter filter, User user){
        session.clear();
        Query<Student> query = session.createQuery("from Student where (user = :user) and " +
                "(transfer = :transfer or :transfer is null) and" +
                "(city = :city or :city is null) and" +
                "(country = :country or :country is null) and" +
                "(presence = :presence or (presence = :presenceM) or :presence is null)", Student.class);

        query.setParameter("user", user);
        query.setParameter("transfer", filter.getTransfer());
        query.setParameter("city", filter.getCity());
        query.setParameter("country", filter.getCountry());
        query.setParameter("presence", filter.getPresence());
        query.setParameter("presenceM", Presence.Mixed);
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");

        List<Student> students = query.list();
        if (!(filter.getSkills()==null)){
            List<Student> studentsFind = new ArrayList();
            for (Student student:students){

                int countFound=0;
                for (String skillToFound: filter.getSkills()){
                    for (Skill skillToCompare: student.getSkills()){
                        if (skillToCompare.getSkill().equalsIgnoreCase(skillToFound))
                            countFound++;
                    }

                }
                if (countFound==filter.getSkills().size())
                    studentsFind.add(student);

            }
            return studentsFind;
        }
        return students;

    }


    @Override
    public List<Student> findAllFilterPage(Filter filter, User user, Integer page, Integer perPage) {
        session.clear();
        Query<Student> query = session.createQuery("from Student where (user = :user) and " +
                "(transfer = :transfer or :transfer is null) and" +
                "(city = :city or :city is null) and" +
                "(country = :country or :country is null) and" +
                "(presence = :presence or (presence = :presenceM) or :presence is null)", Student.class);

        query.setParameter("user", user);
        query.setParameter("transfer", filter.getTransfer());
        query.setParameter("city", filter.getCity());
        query.setParameter("country", filter.getCountry());
        query.setParameter("presence", filter.getPresence());
        query.setParameter("presenceM", Presence.Mixed);
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");

        List<Student> students = query.list();
        if (!(filter.getSkills() == null)) {
            List<Student> studentsFind = new ArrayList();
            for (Student student : students) {

                int countFound = 0;
                for (String skillToFound : filter.getSkills()) {
                    for (Skill skillToCompare : student.getSkills()) {
                        if (skillToCompare.getSkill().equalsIgnoreCase(skillToFound))
                            countFound++;
                    }

                }
                if (countFound == filter.getSkills().size())
                    studentsFind.add(student);

            }
            students = studentsFind;
        }


            int lastPageNum = (int) Math.ceil(students.size() / perPage);
            List<Student> studentsDev;
            if (students.size()==0)
                return null;

            if (students.size() > (page - 1) * perPage + perPage)

                studentsDev = students.subList((page - 1) * perPage, (page - 1) * perPage + perPage);

            else

                studentsDev = students.subList((page - 1) * perPage, students.size());

            studentsDev.get(0).setDocument(Integer.toString(students.size()));

            return studentsDev;

    }



    @Override
    public List<Student> findKeyWord(String keyWord, User user){
        Query<Student> query = session.createQuery("from Student where (user = :user) and ((UPPER(name) " +
                "LIKE UPPER(:keyWord))or(UPPER(email) LIKE UPPER(:keyWord))) ", Student.class);

        String key = ("%"+keyWord+"%");
        query.setParameter("keyWord", key);
        query.setParameter("user", user);

        List<Student> students = query.list();
        return students;

    }


    @Override
    public List<String> findCities(Long id){

        List<String> cities = session.createNativeQuery("SELECT city FROM Student \n" +
                "     GROUP BY city, user_id \n" +
                "     HAVING COUNT(*)>=1 and user_id=:id").setParameter("id",id).list();
        return cities;
    }

    @Override
    public List<String> findCountries(Long id){
        List<String> countries = session.createNativeQuery("SELECT country FROM Student \n" +
                "     GROUP BY country, user_id \n" +
                "     HAVING COUNT(*)>=1 and user_id=:id").setParameter("id",id).list();
        return countries;
    }




}
