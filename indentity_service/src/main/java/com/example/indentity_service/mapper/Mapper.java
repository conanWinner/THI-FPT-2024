package com.example.indentity_service.mapper;


import com.example.indentity_service.dto.response.DotcuutroReponse;
import com.example.indentity_service.dto.response.TruongReponse;
import com.example.indentity_service.entity.Dotcuutro;
import com.example.indentity_service.entity.Truong;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    List<TruongReponse> toTruongResponse(List<Truong> truongs);
    List<DotcuutroReponse> toDotcuutroResponse(List<Dotcuutro> dotcuutros);


}
