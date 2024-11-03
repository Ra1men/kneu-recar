package com.kneu.recar.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "clients")
public class Client {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private String email;
    private String passportNumber;

}
