package com.example.indentity_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data

public class User {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String username;
    String password;
    String fullname;
    LocalDate dob;

}
