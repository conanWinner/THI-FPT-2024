package com.example.indentity_service.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DotcuutroReponse {

    String madotcuutro;
    String khauhieu;

}
