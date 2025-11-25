package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.entitys.enums.TipoSituacaoUsuario;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UsuarioDTO {

    private Long id; // corrigido para minúsculo
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

    private List<SessaoDTO> horarios;

    public UsuarioDTO() {}

    public UsuarioDTO(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario , this);

        if (usuario.getFoto() != null){
            this.foto = java.util.Base64.getEncoder().encodeToString(usuario.getFoto());
        }

        if(usuario.getHorarios() != null){
            this.horarios = usuario.getHorarios().stream()
                    .map(SessaoDTO::new)
                    .toList();
        }
    }

    // ----------------------
    // GETTERS E SETTERS
    // ----------------------

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

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public List<SessaoDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SessaoDTO> horarios) {
        this.horarios = horarios;
    }

    // ----------------------
    // EQUALS E HASHCODE
    // ----------------------

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
