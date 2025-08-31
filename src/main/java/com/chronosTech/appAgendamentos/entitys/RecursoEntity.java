package com.chronosTech.appAgendamentos.entitys;

import com.chronosTech.appAgendamentos.dto.RecursoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

@Table(name = "CHT_RECURSO")
@Entity
public class RecursoEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotBlank
    @Column(nullable = false , unique = true)
    private String chave;

    public RecursoEntity(){

    }

    public RecursoEntity(RecursoDTO recurso){
        BeanUtils.copyProperties(recurso , this);
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

    public @NotBlank String getChave() {
        return chave;
    }

    public void setChave(@NotBlank String chave) {
        this.chave = chave;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        RecursoEntity that = (RecursoEntity) o;
        return Id == that.Id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(Id);
    }
}
