package com.example.indentity_service.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChitietcuutroDTO {

    String masv;
    String matruong;
    String madotcuutro;

    LocalDate ngaycuutro;
    String dexuatcaithien;

}
