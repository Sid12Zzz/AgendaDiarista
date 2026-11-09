package com.agendadiarista.DTO;

import com.agendadiarista.entity.Profissional;
import org.springframework.beans.BeanUtils;

public class ProfissionalDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;



    public ProfissionalDTO(){}

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
}
