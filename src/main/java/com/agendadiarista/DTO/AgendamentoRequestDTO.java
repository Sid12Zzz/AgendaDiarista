package com.agendadiarista.DTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class AgendamentoRequestDTO {

    @NotNull(message = "A data e hora do agendamento não pode ser nula")
    @FutureOrPresent(message = "A data do agendamento deve ser atual ou futura")
    private LocalDate dataHora;

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clienteId;

    @NotNull(message = "O ID do profissional é obrigatório")
    private Long profissionalId;

    // Getters e Setters (necessários para o Spring conseguir ler o JSON que vem do Postman)

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getProfissionalId() {
        return profissionalId;
    }

    public void setProfissionalId(Long profissionalId) {
        this.profissionalId = profissionalId;
    }
}