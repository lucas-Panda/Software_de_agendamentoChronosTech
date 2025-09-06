package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.PerfilEntity;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class PerfilDTO {

    private Long Id;
    private String descricao;

    public PerfilDTO(PerfilEntity perfil){
        BeanUtils.copyProperties(perfil , this);
    }
    public PerfilDTO(){

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PerfilDTO perfilDTO = (PerfilDTO) o;
        return Objects.equals(Id, perfilDTO.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
