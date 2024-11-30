package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    String masv;
    String hoten;
    String tentruong;
    String madotcuutro;
    String khauhieu;
    LocalDate ngaycuutro;
    String dexuatcaithien;

}
