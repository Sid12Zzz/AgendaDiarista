package com.agendadiarista.DTO;

import java.time.LocalDateTime;
import java.util.Map;

public record ErroValidacaoDTO(
        LocalDateTime timestamp,
        Integer status,
        String error,
        Map<String, String> campos,
        String path
) {}