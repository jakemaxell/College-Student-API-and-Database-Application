package com.example.CollegeStudent.repository;

import com.example.CollegeStudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {

    @Query(value = "SELECT * FROM COLLEGE_STUDENT WHERE GPA>=3.5", nativeQuery = true)
    List<Student> honorsList();

    @Query(value = "SELECT * FROM COLLEGE_STUDENT WHERE MAJOR=:major", nativeQuery = true)
    List<Student> retrieveByMajor(String major);

    @Modifying()
    @Transactional
    @Query(value = "UPDATE COLLEGE_STUDENT SET MAJOR=:major WHERE STUDENT_ID=:studentID", nativeQuery = true)
    void changeMajor(String major, String studentID);

}
