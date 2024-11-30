package com.example.indentity_service.service;
import com.example.indentity_service.dto.response.TruongReponse;
import com.example.indentity_service.mapper.Mapper;
import com.example.indentity_service.repository.TruongRepository;
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
public class TruongService {

    TruongRepository truongRepository;
    Mapper mapper;

    public List<TruongReponse> getTruongs(){

        return mapper.toTruongResponse(truongRepository.findAll());

    }


}
