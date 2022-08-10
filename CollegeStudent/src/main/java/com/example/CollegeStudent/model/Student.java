package com.example.CollegeStudent.model;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "COLLEGE_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", name = "STUDENT_ID")
    private UUID studentID;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "MAJOR")
    private Major major;
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "STREET")),
            @AttributeOverride(name = "city", column = @Column(name = "CITY")),
            @AttributeOverride(name = "stateCode", column = @Column(name = "STATE_CODE")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "ZIPCODE"))
    })
    @Embedded
    private Address address;
    @Column(name = "GPA")
    private double gpa;
    @Column(name = "AGE")
    private int age;

    public Student() {
    }

    public Student(String firstName, String lastName, Address address, double gpa, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gpa = gpa;
        this.age = age;
    }

    public void setStatus(){
        if(gpa > 2.5){
            status = Status.GOOD_STANDING;
        }
        else if (gpa <= 2.5 && gpa >= 2.0) {
            status = Status.ACADEMIC_PROBATION;
        }
        else if(gpa < 2.0 && gpa >= 1.0){
            status = Status.SUSPENDED;
        }
        else{
            status = Status.EXPELLED;
        }
    }

}
