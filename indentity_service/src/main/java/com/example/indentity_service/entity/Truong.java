package com.example.indentity_service.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Truong {

    @Id
    String matruong;
    String tentruong;
    String diachi;
    String sdt;


    @OneToMany(mappedBy = "truong", cascade = CascadeType.ALL)
    List<Chitietcuutro> chitietcuutroList;

}