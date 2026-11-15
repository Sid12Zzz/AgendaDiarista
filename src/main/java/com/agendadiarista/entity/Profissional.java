package com.agendadiarista.entity;

import com.agendadiarista.DTO.ProfissionalResponseDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "profissionais")
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Column(name = "telefone", length = 20)
    @NotBlank(message = "O telefone é obrigatório")
    private String telefone;

    @Column(name = "email", length = 100)
    @Email(message = "E-mail inválido")
    private String email;


    public Profissional(ProfissionalResponseDTO profissionalDTO){
        BeanUtils.copyProperties(profissionalDTO, this);
    }

    public Profissional(){}

    // Getters and Setters
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