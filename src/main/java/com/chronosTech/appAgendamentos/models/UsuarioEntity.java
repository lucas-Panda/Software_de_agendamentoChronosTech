package com.chronosTech.appAgendamentos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private int idade;
    private String cpf;

    public Long getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getCPF(){
        return cpf;
    }
    public String nome(){
        return nome;
    }
    public int Idade(){
        return idade;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    public void nome(String nome){
        this.nome = nome;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
}
