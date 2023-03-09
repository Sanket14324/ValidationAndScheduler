package com.customer.springboot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Name cannot be empty or null")
    @NotEmpty(message = "Name cannot be empty or null")
    @Size(min = 2 , max = 20, message = "Name cannot contain less than 2 letters and not more than  20 letters")
    @Column(name = "name")
    private String name;


    @NotNull
    @Email(message = "Must be in proper format")
    @Column(name = "email")
    private String email;

    @Positive
    @Min(18)
    @Column(name = "age")
    private int age;



    @NotNull
    @Pattern(regexp = ".*\\d.*", message = "must contain at least one numeric character")
    @Pattern(regexp = "[A-Z][a-zA-Z]", message = "must contain at least one capital letter")
    @Size(min=8, max=50, message = "password must be more than 8 letters")
    @Column(name = "password")
    private String password;

}
