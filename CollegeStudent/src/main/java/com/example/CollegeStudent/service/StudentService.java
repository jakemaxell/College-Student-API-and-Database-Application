package com.example.CollegeStudent.service;

import com.example.CollegeStudent.model.Student;
import com.example.CollegeStudent.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // GET
    public Optional<Student> retrieveStudentByID(UUID uuid){
        return studentRepository.findById(uuid);
    }

    public List<Student> honorsList(){
        return studentRepository.honorsList();
    }

    public List<Student> retrieveStudentsByMajor(String major){
        return studentRepository.retrieveByMajor(major);
    }

    // POST
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    // PUT
    public void changeMajor(String major, String studentID){
        studentRepository.changeMajor(major, studentID);
    }

}
