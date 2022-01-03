package com.example.Proyecto.First.Commit;

import com.example.Proyecto.First.Commit.entities.Nivel;
import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProyectoFirstCommitApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ProyectoFirstCommitApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		SkillRepository skillRepository = context.getBean(SkillRepository.class);

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

		Set<Skill> fullstackj = new HashSet();
		fullstackj.add(skillangularj);
		fullstackj.add(skilljavaj);
		fullstackj.add(skillreactj);
		fullstackj.add(skillspringj);



		Student student1 = new Student(null,"María Beatriz Vivanco marrero","España", "Madrid",
			"+3464100000","mariab.vivanco@gmail.com", Presence.Mixed, false,
			null,null,null);
		Student student2 = new Student(null,"Leonardo valdes Amaya","España", "Madrid",
				"+3464100001","leonardo@gmail.com", Presence.Remote, false,
				null,null,null);
		Student student3 = new Student(null,"Greidy Valdes Vivanco","España", "Madrid",
				"+3464100003","greidy@gmail.com", Presence.Face_to_face, true,
				null,null,null);
		Student student4 = new Student(null,"Ariel bazan Rey","España", "Madrid",
				"+3464100004","arielo@gmail.com", Presence.Mixed, true,
				null,null,null);
		Student student5 = new Student(null,"Alenis Ching","España", "Valencia",
				"+3464100005","arle@gmail.com", Presence.Mixed, true,
				null,null,null);
		Student student6 = new Student(null,"Roberto Rodriguez","Francia", "Paris",
				"+41256457","roberto@gmail.com", Presence.Mixed, true,
				null,null,null);
		Student student7 = new Student(null,"Juan Perez","Francia", "Paris",
				"+4154879","juan@gmail.com", Presence.Mixed, true,
				null,null,null);

		studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4,student5,student6,student7));




	}

}
