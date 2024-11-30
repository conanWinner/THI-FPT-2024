package com.example.indentity_service.controller;

import com.example.indentity_service.dto.response.DotcuutroReponse;
import com.example.indentity_service.service.DotcuutroService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/dotcuutro")
@CrossOrigin
public class DotcuutroController {

    DotcuutroService dotcuutroService;

    @GetMapping()
    List<DotcuutroReponse> getAlls() {

        return dotcuutroService.getDotcuutros();

    }

}
