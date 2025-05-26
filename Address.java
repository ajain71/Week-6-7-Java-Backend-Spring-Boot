package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "name cannot be empty")
    private String fullName;
 //   @Pattern(regexp = "^[6-9]\\d{9}$", message = "phone number should be 10 digits")
    private long phoneNo;
    private String address;

    public Address(String fullName, long phoneNo, String address) {

        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.address = address;
    }

    public Address() {

    }
}
