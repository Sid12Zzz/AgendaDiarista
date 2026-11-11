package com.agendadiarista.DTO;

import com.agendadiarista.entity.Agendamento;
import com.agendadiarista.entity.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;

    public ClienteResponseDTO(Cliente cliente) {
        BeanUtils.copyProperties(cliente, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
