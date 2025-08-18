package com.chronosTech.appAgendamentos.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Table
@Entity
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String nome;
    private String email;
    private int idade;
    private String cpf;

    public Long getId(){
        return Id;
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
        this.Id = id;
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
