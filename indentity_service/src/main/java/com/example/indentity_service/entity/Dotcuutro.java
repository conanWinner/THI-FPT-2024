package com.example.indentity_service.entity;

import jakarta.persistence.*;
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
public class Dotcuutro {

    @Id
    String madotcuutro;
    String khauhieu;
    LocalDate ngaybatdau;
    LocalDate ngayketthuc;

    @OneToMany(mappedBy = "dotcuutro", cascade = CascadeType.ALL)
    List<Chitietcuutro> chitietcuutroList;

}