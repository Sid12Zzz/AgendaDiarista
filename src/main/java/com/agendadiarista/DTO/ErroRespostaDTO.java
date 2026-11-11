package com.agendadiarista.DTO;

import org.hibernate.mapping.Map;

import java.time.LocalDateTime;

public record ErroRespostaDTO(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String message,
        String path
) {}


