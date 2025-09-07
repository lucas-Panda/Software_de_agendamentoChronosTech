package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.PermissaoPerfilRecursoEntity;
import org.springframework.beans.BeanUtils;

public class PermissaoPerfilRecursoDTO {

    private Long Id;
    private PerfilDTO perfil;
    private RecursoDTO recurso;


    public PermissaoPerfilRecursoDTO(){

    }
    public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissaoPerfilRecurso){
        BeanUtils.copyProperties(permissaoPerfilRecurso , this);

        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null){
            this.perfil = new PerfilDTO(permissaoPerfilRecurso.getPerfil());
        }
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null){
            this.recurso = new RecursoDTO(permissaoPerfilRecurso.getRecurso());
        }

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }

    public RecursoDTO getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoDTO recurso) {
        this.recurso = recurso;
    }
}
