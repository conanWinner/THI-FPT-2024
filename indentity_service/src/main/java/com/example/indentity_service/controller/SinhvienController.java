package com.example.indentity_service.controller;

import com.example.indentity_service.dto.request.SearchRequest;
import com.example.indentity_service.dto.request.SinhvienDTO;
import com.example.indentity_service.dto.response.SearchResponse;
import com.example.indentity_service.service.SinhvienService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/sinhvien")
@CrossOrigin
public class SinhvienController {

    SinhvienService sinhvienService;

    @PostMapping()
    String createRequest(@RequestBody SinhvienDTO request) {

        return sinhvienService.createRequest(request);

    }

    @PostMapping("/search")
    public List<SearchResponse> searchSinhvien(@RequestBody SearchRequest value) {
        return sinhvienService.searchSinhvien(value.getValue());
    }


    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") String id) {
        sinhvienService.deleteById(id);
        return "Xoá thành công";
    }

    @GetMapping("/ping")
    String test(){
        return "pong";
    }


}
