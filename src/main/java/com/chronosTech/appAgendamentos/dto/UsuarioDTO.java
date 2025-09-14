package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.entitys.enums.TipoSituacaoUsuario;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class UsuarioDTO {

    private Long Id;
    private String nome;
    private String email;
    private String senha;

    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números e ter 11 dígitos")
    private String numeroTelefone;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números e ter 11 dígitos")
    @CPF(message = "CPF inválido")
    private String cpf;

    private TipoSituacaoUsuario situacao;

    public UsuarioDTO(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario , this);
    }

    public UsuarioDTO() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
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

    public @Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números e ter 11 dígitos") String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(@Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números e ter 11 dígitos") String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números e ter 11 dígitos") @CPF(message = "CPF inválido") String getCpf() {
        return cpf;
    }

    public void setCpf(@Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números e ter 11 dígitos") @CPF(message = "CPF inválido") String cpf) {
        this.cpf = cpf;
    }

    public TipoSituacaoUsuario getSituacao() {
        return situacao;
    }

    public void setSituacao(TipoSituacaoUsuario situacao) {
        this.situacao = situacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
