package com.agendadiarista.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class ProfissionalRequestDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;
    @Email
    private String email;


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
