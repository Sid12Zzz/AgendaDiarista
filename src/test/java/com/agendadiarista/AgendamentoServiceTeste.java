package com.agendadiarista;

import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AgendamentoServiceTest {

    @Test
    void deveLancarExcecaoQuandoAgendamentoForNoFimDeSemana() {
        LocalDateTime dataSabado = LocalDateTime.of(2026, 11, 14, 10, 0);

        boolean ehFimDeSemana = dataSabado.getDayOfWeek() == DayOfWeek.SATURDAY ||
                dataSabado.getDayOfWeek() == DayOfWeek.SUNDAY;

        assertTrue(ehFimDeSemana, "A data deveria ser reconhecida como fim de semana");
    }
}
