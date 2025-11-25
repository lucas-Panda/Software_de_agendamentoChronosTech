package com.chronosTech.appAgendamentos.entitys;

import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.enums.TipoSituacaoUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;



@Table(name = "CHT_USUARIO")
@Entity
public class UsuarioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false , unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false , unique = true)
    private String numeroTelefone;

    @NotBlank
    @Column(nullable = false , unique = true)
    private String cpf;

    @NotBlank
    @Column(nullable = false)
    private String senha;

    @NotNull
    @Column(nullable = false)
    private boolean loja = false;

    @Column(nullable = true, columnDefinition = "TEXT")
    private String bios;

    @Lob
    @Column(nullable = true, columnDefinition = "LONGBLOB")
    private byte[] foto;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSituacaoUsuario situacao;


    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private List<SessaoEntity> horarios;


    public UsuarioEntity(UsuarioDTO usuario){
        BeanUtils.copyProperties(usuario, this);
    }
    public UsuarioEntity(){
        
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank String email) {
        this.email = email;
    }

    public @NotBlank String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank String senha) {
        this.senha = senha;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(@NotBlank String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public List<SessaoEntity> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SessaoEntity> horarios) {
        this.horarios = horarios;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
