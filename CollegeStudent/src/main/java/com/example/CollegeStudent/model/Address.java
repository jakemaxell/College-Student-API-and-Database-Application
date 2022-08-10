package com.example.CollegeStudent.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {

    private String street;
    private String city;
    private String stateCode;
    private int zipcode;

    public Address() {
    }

    public Address(String street, String city, String stateCode, int zipcode) {
        this.street = street;
        this.city = city;
        this.stateCode = stateCode;
        this.zipcode = zipcode;
    }

}
