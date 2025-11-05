package com.patient_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDto {

    @NotBlank(message = "The name field can not be empty")
    @Size(max = 100, message= "The size of the name field can not be more than 100")
    private String name;

    @NotBlank(message = "Address can not to empty")
    private String address;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "The email is not in right format")
    private String email;

    @NotBlank(message =  "Date of Birth can not be empty")
    private String dateOfBrith;

    @NotBlank(message = "Date of Registration can not be empty")
    private String dateOfRegistration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBrith() {
        return dateOfBrith;
    }

    public void setDateOfBrith(String dateOfBrith) {
        this.dateOfBrith = dateOfBrith;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
