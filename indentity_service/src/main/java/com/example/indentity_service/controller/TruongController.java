package com.example.indentity_service.controller;

import com.example.indentity_service.dto.response.DotcuutroReponse;
import com.example.indentity_service.dto.response.TruongReponse;
import com.example.indentity_service.service.DotcuutroService;
import com.example.indentity_service.service.TruongService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/truong")
@CrossOrigin
public class TruongController {

    TruongService truongService;

    @GetMapping()
    List<TruongReponse> getAlls() {
        return truongService.getTruongs();
    }

}
