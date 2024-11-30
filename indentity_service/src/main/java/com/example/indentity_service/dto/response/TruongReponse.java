package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@CrossOrigin
public class TruongReponse {

    String matruong;
    String tentruong;

}
