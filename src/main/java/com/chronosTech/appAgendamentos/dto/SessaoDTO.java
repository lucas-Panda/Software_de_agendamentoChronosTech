package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.SessaoEntity;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class SessaoDTO {

    private Long id;
    private String nomeHorario;
    private LocalDate dataSessao;
    private LocalTime horaSessao;
    private String local;
    private float preco;
    private Long idPerfil;


    public SessaoDTO(SessaoEntity entity) {
        this.id = entity.getId();
        this.nomeHorario = entity.getNomeHorario();
        this.dataSessao = entity.getDataSessao();
        this.horaSessao = entity.getHoraSessao();
        this.local = entity.getLocal();
        this.preco = entity.getPreco();
        this.idPerfil = entity.getUsuario() != null ? entity.getUsuario().getId() : null;


    }

    public SessaoDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHorario() {
        return nomeHorario;
    }

    public void setNomeHorario(String nomeHorario) {
        this.nomeHorario = nomeHorario;
    }

    public LocalDate getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(LocalDate dataSessao) {
        this.dataSessao = dataSessao;
    }

    public LocalTime getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(LocalTime horaSessao) {
        this.horaSessao = horaSessao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Long getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Long idPerfil) {
        this.idPerfil = idPerfil;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SessaoDTO sessaoDTO = (SessaoDTO) o;
        return Float.compare(preco, sessaoDTO.preco) == 0 && Objects.equals(id, sessaoDTO.id) && Objects.equals(nomeHorario, sessaoDTO.nomeHorario) && Objects.equals(dataSessao, sessaoDTO.dataSessao) && Objects.equals(horaSessao, sessaoDTO.horaSessao) && Objects.equals(local, sessaoDTO.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeHorario, dataSessao, horaSessao, local, preco);
    }
}

