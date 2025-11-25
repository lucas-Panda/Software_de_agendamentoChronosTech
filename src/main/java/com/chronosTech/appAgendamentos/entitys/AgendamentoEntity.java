package com.chronosTech.appAgendamentos.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "agendamentos")
public class AgendamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idPrestador;
    private Long horarioId;
    private Long idUsuario;

    // getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdPrestador() { return idPrestador; }
    public void setIdPrestador(Long idPrestador) { this.idPrestador = idPrestador; }

    public Long getHorarioId() { return horarioId; }
    public void setHorarioId(Long horarioId) { this.horarioId = horarioId; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
}