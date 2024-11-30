package com.example.indentity_service.repository;

import com.example.indentity_service.dto.response.SearchResponse;
import com.example.indentity_service.entity.Sinhvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, String> {

    @Query("SELECT new com.example.indentity_service.dto.response.SearchResponse(sv.masv, sv.hoten, tr.tentruong, dct.madotcuutro, dct.khauhieu, ct.ngaycuutro, ct.dexuatcaithien) FROM Sinhvien as sv\n" +
            "    join sv.chitietcuutroList as ct \n" +
            "    join ct.truong as tr " +
            "    join ct.dotcuutro as dct " +
            " WHERE sv.hoten = :value or tr.tentruong = :value or dct.madotcuutro = :value")
    List<SearchResponse> findCuutro(@Param("value") String value);



}
