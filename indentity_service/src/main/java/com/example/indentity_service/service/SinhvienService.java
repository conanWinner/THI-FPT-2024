package com.example.indentity_service.service;

import com.example.indentity_service.dto.request.ChitietcuutroDTO;
import com.example.indentity_service.dto.request.SinhvienDTO;
import com.example.indentity_service.dto.response.SearchResponse;
import com.example.indentity_service.entity.Chitietcuutro;
import com.example.indentity_service.entity.Dotcuutro;
import com.example.indentity_service.entity.Sinhvien;
import com.example.indentity_service.entity.Truong;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.repository.DotcuutroRepository;
import com.example.indentity_service.repository.SinhvienRepository;
import com.example.indentity_service.repository.TruongRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
public class SinhvienService {

    SinhvienRepository sinhvienRepository;
    TruongRepository truongRepository;
    DotcuutroRepository dotcuutroRepository;
    Mapper mapper;

    @Transactional
    public String createRequest(SinhvienDTO request){

        Sinhvien sinhvien = Sinhvien.builder()
                .masv(request.getMasv())
                .email(request.getEmail())
                .hoten(request.getHoten())
                .sdt(request.getSdt())
                .build();

        List<Chitietcuutro> chitietcuutroList = new ArrayList<>();

        for (ChitietcuutroDTO chitietcuutroDTO: request.getChitietcuutroDTOS()) {

            Truong truong = truongRepository.findById(chitietcuutroDTO.getMatruong())
                    .orElseThrow(() -> new RuntimeException("Trường không tồn tại"));
            Dotcuutro dotcuutro = dotcuutroRepository.findById(chitietcuutroDTO.getMadotcuutro())
                    .orElseThrow(() -> new RuntimeException("Ngành không tồn tại"));

            Chitietcuutro chitietcuutro = Chitietcuutro.builder()
                    .ngaycuutro(chitietcuutroDTO.getNgaycuutro())
                    .dexuatcaithien(chitietcuutroDTO.getDexuatcaithien())
                    .dotcuutro(dotcuutro)
                    .truong(truong)
                    .sinhvien(sinhvien)
                    .build();

            chitietcuutroList.add(chitietcuutro);

        }

        sinhvien.setChitietcuutroList(chitietcuutroList);

        sinhvienRepository.save(sinhvien);
        return "Thanh cong";

    }

    public List<SearchResponse> searchSinhvien (String value) {
        return sinhvienRepository.findCuutro(value);
    }

    public void deleteById(String id) {
        sinhvienRepository.deleteById(id);
    }

}
