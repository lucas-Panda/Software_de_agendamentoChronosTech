package com.chronosTech.appAgendamentos.entitys;

import jakarta.persistence.*;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "Horario_Disponivel")
@Entity
public class HorarioDisponivelEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime horario;

    @ManyToOne
    private UsuarioEntity profissional;

    private boolean ocupado = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public UsuarioEntity getProfissional() {
        return profissional;
    }

    public void setProfissional(UsuarioEntity profissional) {
        this.profissional = profissional;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
