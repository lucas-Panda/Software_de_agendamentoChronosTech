package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.entitys.enums.TipoSituacaoUsuario;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Objects;



public class UsuarioDTO {

    private Long Id;
    private String nome;
    private String email;
    private String senha;
    private boolean loja;
    private String bios;
    private Date dataCadastro;
    private String foto;

    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números e ter 11 dígitos")
    private String numeroTelefone;

    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas números e ter 11 dígitos")
    @CPF(message = "CPF inválido")
    private String cpf;

    private TipoSituacaoUsuario situacao;

    public UsuarioDTO(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario , this);

        if (usuario.getFoto() != null){
            this.foto = java.util.Base64.getEncoder().encodeToString(usuario.getFoto());
        }
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

    public boolean isLoja() {

        return loja;
    }

    public void setLoja(boolean loja) {
        this.loja = loja;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bios) {
        this.bios = bios;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
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
