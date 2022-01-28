package com.example.Proyecto.First.Commit;

import com.example.Proyecto.First.Commit.dao.StudentDAO;
import com.example.Proyecto.First.Commit.dto.Filter;
import com.example.Proyecto.First.Commit.entities.*;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import java.util.*;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.hibernate.query.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;

@SpringBootApplication
public class ProyectoFirstCommitApplication {

	public int page=0, perPage=0;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(ProyectoFirstCommitApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		SkillRepository skillRepository = context.getBean(SkillRepository.class);

		StudentDAO studentDAO =context.getBean(StudentDAO.class);

		//Incluir datos de prueba


		Skill skilljavaj =new Skill ("Java", Nivel.JUNIOR);
		Skill skilljavas =new Skill ("Java", Nivel.SENIOR);
		Skill skilljavass =new Skill ("Java", Nivel.SEMI_SENIOR);
		Skill skillspringj =new Skill ("Spring", Nivel.JUNIOR);
		Skill skillsprings =new Skill ("Spring", Nivel.SENIOR);
		Skill skillspringss =new Skill ("Spring", Nivel.SEMI_SENIOR);
		Skill skillreactj =new Skill ("React", Nivel.JUNIOR);
		Skill skillreacts =new Skill ("React", Nivel.SENIOR);
		Skill skillreactss =new Skill ("React", Nivel.SEMI_SENIOR);
		Skill skillangularj =new Skill ("Angular", Nivel.JUNIOR);
		Skill skillangulars =new Skill ("Angular", Nivel.SENIOR);
		Skill skillangularss =new Skill ("Angular", Nivel.SEMI_SENIOR);

		ArrayList<Skill>  skills = new ArrayList<>(Arrays.asList(skilljavaj,skilljavas,skilljavass,
				skillspringj,skillsprings,skillspringss, skillreactj, skillreacts,skillreactss,
				skillangularj,skillangularss,skillangulars));

		skillRepository.saveAll(skills);

		Skill skillphpj =new Skill ("PHP", Nivel.JUNIOR);
		Skill skillphps =new Skill ("PHP", Nivel.SENIOR);
		Skill skillphpss =new Skill ("PHP", Nivel.SEMI_SENIOR);
		Skill skillpythonj =new Skill ("Python", Nivel.JUNIOR);
		Skill skillpythons =new Skill ("Python", Nivel.SENIOR);
		Skill skillpythonss =new Skill ("Python", Nivel.SEMI_SENIOR);

		ArrayList<Skill>  skills1 = new ArrayList<>(Arrays.asList(skillphps,skillphpj,skillphpss,
				skillpythonss,skillpythons,skillpythonj));

		skillRepository.saveAll(skills1);

		Set<Skill> fullstackj = new HashSet();
		fullstackj.add(skillangularj);
		fullstackj.add(skilljavaj);
		fullstackj.add(skillreactj);
		fullstackj.add(skillspringj);

		Set<Skill> frontendj = new HashSet();
		frontendj.add(skillangularj);
		frontendj.add(skillreactj);

		Set<Skill> fullstacks = new HashSet();
		fullstacks.add(skillangulars);
		fullstacks.add(skilljavas);
		fullstacks.add(skillreacts);
		fullstacks.add(skillsprings);

		Set<Skill> frontends = new HashSet();
		frontends.add(skillangulars);
		frontends.add(skillreacts);

		Set<Skill> backinit = new HashSet();
		backinit.add(skilljavaj);

		Set<Skill> frontinit = new HashSet();
		frontinit.add(skillreactj);

		Set<Skill> phppython = new HashSet();
		frontinit.add(skillphpj);
		frontinit.add(skillpythonj);



		User user = new User (1L,"admin@gmail.com","$2a$10$DTAejq8zVwf.dMadV1SAvuNXAbXjroY.G7dWpS1tzoGolwn7nexTm",
				null,null);
		User user2 = new User ("admin2@gmail.com","$2a$10$DTAejq8zVwf.dMadV1SAvuNXAbXjroY.G7dWpS1tzoGolwn7nexTm",
				null,null);

		userRepository.save(user);
		userRepository.save(user2);



		Student student1 = new Student(null,"María Beatriz Vivanco marrero","España", "Madrid",
			"3464100000","mariab.vivanco@gmail.com", Presence.Mixed, false,
			fullstackj,null,null,user);
		Student student2 = new Student(null,"Leonardo Valdes Amaya","España", "Madrid",
				"3464100001","leonardo@gmail.com", Presence.Remote, false,
				frontendj,null,null, user);
		Student student3 = new Student(null,"Greidy Valdes Vivanco","España", "Madrid",
				"3464100003","greidy@gmail.com", Presence.Face_to_face, true,
				frontendj,null,null, user);
		Student student4 = new Student(null,"Ariel Bazan Rey","España", "Madrid",
				"3464100004","arielo@gmail.com", Presence.Mixed, true,
				fullstacks,null,null, user);
		Student student5 = new Student(null,"Alenis Ching Valeriana","España", "Valencia",
				"3464100005","arle@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);
		Student student6 = new Student(null,"Roberto Rodriguez","Francia", "Paris",
				"3325645742","roberto@gmail.com", Presence.Mixed, true
				,frontinit,null,null, user);
		Student student7 = new Student(null,"Juan Perez","Francia", "Paris",
				"334154879","juan@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);

		Student student8 = new Student(null,"Eleonor Velazco Antunes","Inglaterra", "Londres",
				"441548792","eleonor@gmail.com", Presence.Remote, false,
				phppython,null,null, user);

		Student student9 = new Student(null,"Juan Perez Díaz","Chile", "Santiago de Chile",
				"563154879","juanp@gmail.com", Presence.Remote, true,
				phppython,null,null, user);
		Student student11 = new Student(null,"Ramiro Rodriguez Pajares","Cuba", "La Habana",
				"53464100000","ramiro.rodriguez@nauta.cu", Presence.Face_to_face, false,
				fullstackj,null,null,user);
		Student student12 = new Student(null,"Arael Saez Sanchez","España", "Barcelona",
				"3464102001","arael234@yahoo.es", Presence.Remote, false,
				frontendj,null,null, user);
		Student student13 = new Student(null,"Elizabeth Alonso Peña","España", "Bilbao",
				"3464100203","elizabeth@gmail.com", Presence.Face_to_face, true,
				frontendj,null,null, user);
		Student student14 = new Student(null,"Ariel Perea Pla","España", "Madrid",
				"3464100204","arielo@gmail.com", Presence.Remote, false,
				fullstacks,null,null, user);
		Student student15 = new Student(null,"Franklin Mujica Aragones","España", "Valencia",
				"3464107005","fran3423@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);
		Student student16 = new Student(null,"Roberto Sabori Rodriguez","Argentina", "Buenos Aires",
				"541256457","robertosab@gmail.com", Presence.Mixed, true
				,frontinit,null,null, user);
		Student student17 = new Student(null,"Eleonora Franzua Gode","Francia", "Paris",
				"+335487922","juan@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);

		Student student18 = new Student(null,"Max Johnson Willians","Inglaterra", "Londres",
				"441548792","max34223@gmail.com", Presence.Remote, false,
				phppython,null,null, user);

		Student student19 = new Student(null,"Barbara Sauri Alonso","Chile", "Santiago de Chile",
				"5623154879","barbarasauri@gmail.com", Presence.Remote, false,
				phppython,null,null, user);



		studentRepository.save(student1);
		studentRepository.save(student2);
		studentRepository.save(student3);
		studentRepository.save(student4);
		studentRepository.save(student5);
		studentRepository.save(student6);
		studentRepository.save(student7);
		studentRepository.save(student8);
		studentRepository.save(student9);

		studentRepository.save(student11);
		studentRepository.save(student12);
		studentRepository.save(student13);
		studentRepository.save(student14);
		studentRepository.save(student15);
		studentRepository.save(student16);
		studentRepository.save(student17);
		studentRepository.save(student18);
		studentRepository.save(student19);




	}





}
