package com.agendadiarista.DTO;

import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.entity.StatusPagamento;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendamentoResponseDTO {

    private Long id;
    private LocalDate dataHora;
    private StatusPagamento statusPagamento;
    private LocalDateTime createdAt;
    private Long clienteId;
    private String clienteNome;
    private Long profissionalId;
    private String profissionalNome;

    public AgendamentoResponseDTO(Agendamento agendamento) {
        BeanUtils.copyProperties(agendamento, this);
        this.id = agendamento.getId();
        this.dataHora = agendamento.getDataHora();
        this.createdAt = agendamento.getCreatedAt();
        this.statusPagamento = agendamento.getStatusPagamento();

        if (agendamento.getCliente() != null) {
            this.clienteId = agendamento.getCliente().getId();
            this.clienteNome = agendamento.getCliente().getNome();
        }

        if (agendamento.getProfissional() != null) {
            this.profissionalId = agendamento.getProfissional().getId();
            this.profissionalNome = agendamento.getProfissional().getNome();
        }
    }

    public Long getId() { return id; }
    public LocalDate getDataHora() { return dataHora; }
    public StatusPagamento getStatusPagamento() { return statusPagamento; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public Long getClienteId() { return clienteId; }
    public String getClienteNome() { return clienteNome; }
    public Long getProfissionalId() { return profissionalId; }
    public String getProfissionalNome() { return profissionalNome; }
}