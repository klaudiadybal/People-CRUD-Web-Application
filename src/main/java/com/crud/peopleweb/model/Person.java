package com.crud.peopleweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "Enter first name.")
    private String firstName;

    @NotEmpty(message = "Enter last name.")
    private String lastName;

    @Email(message = "Email must be valid.")
    @NotEmpty(message = "Enter email.")
    private String email;

    @Past(message = "Date of birth must be valid.")
    @NotNull(message = "Enter date of birth.")
    private LocalDate dob;

    @DecimalMin(value="999", message = "Salary must be at least 1000.")
    @NotNull(message = "Enter salary.")
    private BigDecimal salary;
}
