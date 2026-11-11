package com.agendadiarista.DTO;

import org.hibernate.mapping.Map;

import java.time.LocalDateTime;

public record ErroValidacaoDTO(
        LocalDateTime timestamp,
        Integer status,
        String error,
      //  Map<String, String> campos,
        String path
) {}