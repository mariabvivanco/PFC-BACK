package com.example.Proyecto.First.Commit.controller;

import com.example.Proyecto.First.Commit.dao.StudentDAO;
import com.example.Proyecto.First.Commit.dto.Filter;
import com.example.Proyecto.First.Commit.dto.StudentDTO;
import com.example.Proyecto.First.Commit.entities.Presence;
import com.example.Proyecto.First.Commit.entities.Skill;
import com.example.Proyecto.First.Commit.entities.Student;
import com.example.Proyecto.First.Commit.entities.User;
import com.example.Proyecto.First.Commit.repository.SkillRepository;
import com.example.Proyecto.First.Commit.repository.StudentRepository;
import com.example.Proyecto.First.Commit.repository.UserRepository;
import com.example.Proyecto.First.Commit.service.student.StudentService;
import com.example.Proyecto.First.Commit.service.student.StudentServiceImpl;
import com.example.Proyecto.First.Commit.service.uploadfile.UploadFile;
import com.example.Proyecto.First.Commit.service.uploadfile.UploadFileImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final Logger log = LoggerFactory.getLogger(StudentController.class);
    private SkillRepository skillRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    private StudentDAO studentDAO;


    public StudentController(StudentDAO studentDAO, SkillRepository skillRepository, StudentRepository studentRepository,
                             UserRepository userRepository) {
        this.skillRepository = skillRepository;
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.studentDAO = studentDAO;

    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);

    }

    @GetMapping("/allUser")
    public List<Student> getAllStudentUser() {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);

        return studentDAO.findAll(optionalUser.get());
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Student> getStudentByCityUser(@PathVariable Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent())
            return ResponseEntity.ok(optionalStudent.get());
        else return ResponseEntity.notFound().build();
    }


    @GetMapping("/city/{nameCity}")
    public Set<Student> getStudentByCityUser(@PathVariable String nameCity) {

        List<Student> studentUserAll = studentRepository.findAll();
        Set<Student> students = new HashSet<>();
        for (Student student: studentUserAll) {
            if (student.getCity().equalsIgnoreCase(nameCity))
                students.add(student);
        }
                return students;
    }

    @GetMapping("/cityUser/{nameCity}")
    public List<Student> getStudentByCity(@PathVariable String nameCity) {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findCity(nameCity,optionalUser.get());

        return students;
    }

    @GetMapping("/presenceUser/{typePresence}")
    public List<Student> getStudentByPresence(@PathVariable String typePresence) {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        Presence presc;
        if (typePresence.equalsIgnoreCase("Remote"))
            presc = Presence.Remote;
        else if (typePresence.equalsIgnoreCase("Mixed"))
            presc = Presence.Mixed;
        else if (typePresence.equalsIgnoreCase("Presence"))
            presc = Presence.Face_to_face;
        else return null;


        List<Student> students= studentDAO.findPresence(presc,optionalUser.get());
        return students;
    }

    @GetMapping("/countryUser/{nameCountry}")
    public List<Student> getStudentByCountry(@PathVariable String nameCountry) {

        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findCountry(nameCountry,optionalUser.get());
        return students;
    }

    @GetMapping("/transferUser/{typeTransfer}")
    public List<Student> getStudentByTransfery(@PathVariable String typeTransfer) {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);

        //todo lo convierte a falso sino es true ver si hay que arreglar

        Boolean transfer = Boolean.parseBoolean(typeTransfer);
        List<Student> students= studentDAO.findTransfer(transfer,optionalUser.get());
        return students;
    }

    @GetMapping("/skillsUser")
    public List<Student> getStudentBySkylls(@RequestBody Set<Skill> skills) {
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findSkills(skills,optionalUser.get());
        return students;
    }

    @PostMapping("/allFilter")
    public ResponseEntity<List<Student> >getStudentAllFilter(@RequestBody Filter filter){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findAllFilter(filter,optionalUser.get());
        return ResponseEntity.ok(students);

    }

    @PostMapping("/allFilterPerPage/{page}/{perPage}")
    public ResponseEntity<List<Student> >getStudentAllFilterPerPage(@RequestBody Filter filter, @PathVariable Integer page, @PathVariable Integer perPage  ){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findAllFilterPage(filter,optionalUser.get(),page,perPage);
        return ResponseEntity.ok(students);

    }

    @GetMapping("/keyWord")
    public ResponseEntity<List<Student> >getStudentAllFilter(@RequestParam String keyWord){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<Student> students= studentDAO.findKeyWord(keyWord, optionalUser.get());
        return ResponseEntity.ok(students);

    }

    @GetMapping("/city")
    public ResponseEntity<List<String> >getCitiesforUser(){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<String> cities= studentDAO.findCities(optionalUser.get().getId());
        return ResponseEntity.ok(cities);

    }

    @GetMapping("/country")
    public ResponseEntity<List<String> >getCountriesforUser(){
        String userName= SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        List<String> cities= studentDAO.findCountries(optionalUser.get().getId());
        return ResponseEntity.ok(cities);

    }



    @PostMapping("create")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO student) throws Exception {

        Student studentTemp = new Student();
        StudentService studentService = new StudentServiceImpl();
        Set<Skill> skills = new HashSet<>();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userRepository.findByemail(userName);
        if (student.getId() != null) {
            log.warn("trying to create a stud with id");
            return ResponseEntity.badRequest().build();
        } else {

            if (!(studentService.validateStudentCreate(student))) {
                log.warn("input data error");
                return ResponseEntity.badRequest().build();
            }

            if (student.getSkills() == null)
                studentTemp = studentService.convertStudentCreate(student, null);
            else
                for (String skillNew : student.getSkills()) {
                    Skill skill = new Skill();
                    skills.add(studentDAO.findSkill(skillNew));
                }
            studentTemp = studentService.convertStudentCreate(student, skills);
            studentTemp.setUser(optionalUser.get());

            studentRepository.save(studentTemp);
            return ResponseEntity.ok(studentTemp);

        }
    }

    @PostMapping("create/document/{id}")
    public ResponseEntity<Student> createStudentDocument(@PathVariable Long id, @RequestBody MultipartFile document) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(id);
        UploadFile uploadFile = new UploadFileImpl();
        studentOptional.get().setDocument(uploadFile.uploadPdf(document));
        studentRepository.saveAndFlush(studentOptional.get());
        System.out.println("creada documento ok");
        return ResponseEntity.ok(studentOptional.get());
        }

    @PostMapping("create/photo/{id}")
    public ResponseEntity<Student> createStudentPhoto(@PathVariable Long id, @RequestBody MultipartFile photo) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(id);
        UploadFile uploadFile = new UploadFileImpl();
        studentOptional.get().setPhoto(uploadFile.uploadImage(photo));
        studentRepository.saveAndFlush(studentOptional.get());
        System.out.println("creada foto ok");
        return ResponseEntity.ok(studentOptional.get());
    }



    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent( @PathVariable Long id, @RequestBody StudentDTO studentNew) throws Exception {

        //TODO validar datos de entrada y requisitos
        Optional<Student> optStudent = studentRepository.findById(id);
        StudentService studentService = new StudentServiceImpl();

        if (optStudent.isPresent()) {
            Student student=studentService.convertStudentUpdate(studentNew, optStudent.get());
            studentRepository.saveAndFlush(student);
            System.out.println("actualizado estudiante ok");
            return  ResponseEntity.ok(student);
        }else {
            log.warn("trying to update a student that does not exist");
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("update/document/{id}")
    public ResponseEntity<Student> updateStudentDocument(@PathVariable Long id, @RequestBody MultipartFile document) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(id);
        UploadFile uploadFile = new UploadFileImpl();
        studentOptional.get().setDocument(uploadFile.uploadPdf(document));
        studentRepository.saveAndFlush(studentOptional.get());
        System.out.println("actualizado documento ok");
        return ResponseEntity.ok(studentOptional.get());
    }

    @PutMapping("delete/document/{id}")
    public ResponseEntity<Student> deleteStudentDocument(@PathVariable Long id) throws Exception {
        Optional<Student> studentOptional = studentRepository.findById(id);
        studentOptional.get().setDocument(null);
        studentRepository.saveAndFlush(studentOptional.get());
        System.out.println("eliminado documento ok");
        return ResponseEntity.ok(studentOptional.get());
    }



    @DeleteMapping("/all")
    public ResponseEntity<?> deleteAllStudent() {

        studentRepository.deleteAll();
        log.warn("all students were deleted ");
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Skill> deleteStudentlId(@PathVariable Long id) {

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setSkills(null);
            student.setUser(null);
            studentRepository.save(student);
            studentRepository.delete(student);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("trying to delete a student that does not exist");
            return ResponseEntity.badRequest().build();
        }
    }




}
