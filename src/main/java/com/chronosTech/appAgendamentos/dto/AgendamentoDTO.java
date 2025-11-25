package com.chronosTech.appAgendamentos.dto;

public class AgendamentoDTO {
    private Long Id;
    private Long idPrestador;
    private Long horarioId;
    private Long idUsuario;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdPrestador() {
        return idPrestador;
    }

    public void setIdPrestador(Long idPrestador) {
        this.idPrestador = idPrestador;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
