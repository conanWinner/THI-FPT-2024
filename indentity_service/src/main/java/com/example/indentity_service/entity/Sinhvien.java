package com.example.indentity_service.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Sinhvien {

    @Id
    String masv;
    String hoten;
    String sdt;
    String email;

    @OneToMany(mappedBy = "sinhvien", cascade = CascadeType.ALL)
    List<Chitietcuutro> chitietcuutroList;

}