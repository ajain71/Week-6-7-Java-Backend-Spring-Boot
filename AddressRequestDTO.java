package com.example;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AddressRequestDTO {

    @NotNull(message = "name cannot be null")
    private String fullName;
    private long phoneNo;
    private String address;

    public AddressRequestDTO(String fullName, long phoneNo, String address) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.address = address;
    }
}
