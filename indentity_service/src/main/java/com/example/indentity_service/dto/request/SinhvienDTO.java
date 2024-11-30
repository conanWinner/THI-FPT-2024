package com.example.indentity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SinhvienDTO {

    String masv;
    String hoten;
    String sdt;
    String email;
    List<ChitietcuutroDTO> chitietcuutroDTOS;

}
