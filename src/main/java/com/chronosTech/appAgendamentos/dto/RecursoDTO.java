package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.RecursoEntity;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

public class RecursoDTO {

    private Long Id ;
    private String nome;
    private String chave;


    public RecursoDTO(){

    }
    public RecursoDTO(RecursoEntity recurso){
        BeanUtils.copyProperties(recurso , this);
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        RecursoDTO that = (RecursoDTO) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
