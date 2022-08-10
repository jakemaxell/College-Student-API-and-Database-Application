package com.example.CollegeStudent.controller;

import com.example.CollegeStudent.model.Address;
import com.example.CollegeStudent.model.Student;
import com.example.CollegeStudent.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // GET
    @GetMapping("/retrieve-student-by-id/{id}")
    public Optional<Student> retrieveStudentByID(@PathVariable("id") UUID uuid){
        return studentService.retrieveStudentByID(uuid);
    }

    @GetMapping("/honors-list")
    public List<Student> honorsList(){
        return studentService.honorsList();
    }

    @GetMapping("/get-students-by-major/{major}")
    public List<Student> getStudentsByMajor(@PathVariable("major") String major){
        return studentService.retrieveStudentsByMajor(major);
    }

    // POST
    @PostMapping("/create-student")
    public Student createStudent(@RequestBody Student student){
        student.setStatus();
        return studentService.saveStudent(student);
    }

    // PUT
    @PutMapping("/change-major/{major}/{studentID}")
    public void changeMajor(@PathVariable("major") String major, @PathVariable("studentID") String studentID){
        studentService.changeMajor(major, studentID);
        System.out.println("Student: " + studentID + "'s Major has been updated to " + major);
    }

    // DELETE

}
