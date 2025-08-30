package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {
    private long Id;
    private String nome;
    private String email;
    private String senha;
    private long numeroTelefone;
    private long cpf;

    public UsuarioDTO(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario , this);
    }

    public UsuarioDTO() {

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(long numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}
