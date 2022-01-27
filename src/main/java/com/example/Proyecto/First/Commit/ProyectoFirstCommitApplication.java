package com.example.Proyecto.First.Commit;

import com.example.Proyecto.First.Commit.dao.StudentDAO;
import com.example.Proyecto.First.Commit.dto.Filter;
import com.example.Proyecto.First.Commit.dto.FilterPrueba;
import com.example.Proyecto.First.Commit.entities.*;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import java.util.*;
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
			"+3464100000","mariab.vivanco@gmail.com", Presence.Mixed, false,
			fullstackj,null,null,user);
		Student student2 = new Student(null,"Leonardo valdes Amaya","España", "Madrid",
				"+3464100001","leonardo@gmail.com", Presence.Remote, false,
				frontendj,null,null, user);
		Student student3 = new Student(null,"Greidy Valdes Vivanco","España", "Madrid",
				"+3464100003","greidy@gmail.com", Presence.Face_to_face, true,
				frontendj,null,null, user);
		Student student4 = new Student(null,"Ariel bazan Rey","España", "Madrid",
				"+3464100004","arielo@gmail.com", Presence.Mixed, true,
				fullstacks,null,null, user);
		Student student5 = new Student(null,"Alenis Ching","España", "Valencia",
				"+3464100005","arle@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);
		Student student6 = new Student(null,"Roberto Rodriguez","Francia", "Paris",
				"+41256457","roberto@gmail.com", Presence.Mixed, true
				,frontinit,null,null, user);
		Student student7 = new Student(null,"Juan Perez","Francia", "Paris",
				"+4154879","juan@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);

		Student student8 = new Student(null,"Eleonor Velazco Antunes","Inglaterra", "Londres",
				"+4154879ss","eleonor@gmail.com", Presence.Mixed, false,
				phppython,null,null, user);

		Student student9 = new Student(null,"Juan Perez Díaz","Chile", "santiago de Chile",
				"+423154879","juanp@gmail.com", Presence.Mixed, true,
				phppython,null,null, user);
		Student student11 = new Student(null,"María Beatriz Vivanco marrero","España", "Madrid",
				"+3464100000","mariab.vivanco@gmail.com", Presence.Mixed, false,
				fullstackj,null,null,user);
		Student student12 = new Student(null,"Leonardo valdes Amaya","España", "Madrid",
				"+3464100001","leonardo@gmail.com", Presence.Remote, false,
				frontendj,null,null, user);
		Student student13 = new Student(null,"Greidy Valdes Vivanco","España", "Madrid",
				"+3464100003","greidy@gmail.com", Presence.Face_to_face, true,
				frontendj,null,null, user);
		Student student14 = new Student(null,"Ariel bazan Rey","España", "Madrid",
				"+3464100004","arielo@gmail.com", Presence.Mixed, true,
				fullstacks,null,null, user);
		Student student15 = new Student(null,"Alenis Ching","España", "Valencia",
				"+3464100005","arle@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);
		Student student16 = new Student(null,"Roberto Rodriguez","Francia", "Paris",
				"+41256457","roberto@gmail.com", Presence.Mixed, true
				,frontinit,null,null, user);
		Student student17 = new Student(null,"Juan Perez","Francia", "Paris",
				"+4154879","juan@gmail.com", Presence.Mixed, true,
				backinit,null,null, user);

		Student student18 = new Student(null,"Eleonor Velazco Antunes","Inglaterra", "Londres",
				"+4154879ss","eleonor@gmail.com", Presence.Mixed, false,
				phppython,null,null, user);

		Student student19 = new Student(null,"Juan Perez Díaz","Chile", "santiago de Chile",
				"+423154879","juanp@gmail.com", Presence.Mixed, true,
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

	/*@Bean
	public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
			if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
				// - 1 significa ilimitado
				((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
			}
		});
		return tomcat;
	}*/

}
