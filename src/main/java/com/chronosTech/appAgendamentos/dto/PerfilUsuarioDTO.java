package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.PerfilUsuarioEntity;
import org.springframework.beans.BeanUtils;

public class PerfilUsuarioDTO {

    private Long Id;
    private UsuarioDTO usuario;
    private PerfilDTO perfil;



    public PerfilUsuarioDTO(){

    }

    public PerfilUsuarioDTO(PerfilUsuarioEntity perfilUsuario){
        BeanUtils.copyProperties(perfilUsuario , this);
        if(perfilUsuario != null && perfilUsuario.getUsuario() != null){
            this.usuario = new UsuarioDTO(perfilUsuario.getUsuario());
        }
        if(perfilUsuario != null && perfilUsuario.getPerfil() != null){
            this.perfil = new PerfilDTO(perfilUsuario.getPerfil());
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public PerfilDTO getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilDTO perfil) {
        this.perfil = perfil;
    }
}
