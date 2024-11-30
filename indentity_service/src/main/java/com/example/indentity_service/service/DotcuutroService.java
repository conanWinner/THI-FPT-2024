package com.example.indentity_service.service;

import com.example.indentity_service.dto.response.DotcuutroReponse;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.repository.DotcuutroRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal=true)
@RequiredArgsConstructor
@Slf4j
public class DotcuutroService {

    DotcuutroRepository dotcuutroRepository;
    Mapper mapper;

    public List<DotcuutroReponse> getDotcuutros(){

        return mapper.toDotcuutroResponse(dotcuutroRepository.findAll());

    }


}
