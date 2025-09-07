package com.chronosTech.appAgendamentos.entitys;

import com.chronosTech.appAgendamentos.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "PERMISSAO_PERFIL_RECURSO")
public class PermissaoPerfilRecursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    @ManyToOne
    @JoinColumn(name = "ID_RECURSO")
    private RecursoEntity recurso;


    public PermissaoPerfilRecursoEntity(){

    }

    public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        BeanUtils.copyProperties(permissaoPerfilRecurso , this);
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getPerfil() != null){
            this.perfil = new PerfilEntity(permissaoPerfilRecurso.getPerfil());
        }
        if(permissaoPerfilRecurso != null && permissaoPerfilRecurso.getRecurso() != null){
            this.recurso = new RecursoEntity(permissaoPerfilRecurso.getRecurso());
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

    public RecursoEntity getRecurso() {
        return recurso;
    }

    public void setRecurso(RecursoEntity recurso) {
        this.recurso = recurso;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        PermissaoPerfilRecursoEntity that = (PermissaoPerfilRecursoEntity) o;
        return Objects.equals(Id, that.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }
}
