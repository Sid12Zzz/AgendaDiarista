package com.agendadiarista.DTO;

import com.agendadiarista.entity.Cliente;
import com.agendadiarista.entity.Profissional;
import com.agendadiarista.entity.StatusPagamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendamentoDTO {
    private Long id;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    private Cliente cliente;
    private Profissional profissional;
    private LocalDate dataHora;
    private StatusPagamento statusPagamento ;
    private LocalDateTime createdAt;



}
