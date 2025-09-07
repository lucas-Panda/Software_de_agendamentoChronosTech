package com.chronosTech.appAgendamentos.entitys;

import com.chronosTech.appAgendamentos.dto.PerfilDTO;
import com.chronosTech.appAgendamentos.dto.PerfilUsuarioDTO;
import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "CHT_PERFIL_USUARIO")
public class PerfilUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;


    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity  perfil;

    public PerfilUsuarioEntity (){

    }

    public PerfilUsuarioEntity(PerfilUsuarioDTO perfilUsuario){
        BeanUtils.copyProperties(perfilUsuario , this);
        if(perfilUsuario != null && perfilUsuario.getUsuario() != null){
            this.usuario = new UsuarioEntity(perfilUsuario.getUsuario());
        }
        if(perfilUsuario != null && perfilUsuario.getPerfil() != null){
            this.perfil = new PerfilEntity(perfilUsuario.getPerfil());
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PerfilUsuarioEntity that = (PerfilUsuarioEntity) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}

