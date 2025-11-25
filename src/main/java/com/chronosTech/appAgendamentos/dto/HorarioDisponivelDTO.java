package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.HorarioDisponivelEntity;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class HorarioDisponivelDTO {

    private Long id;
    private LocalDateTime horario;
    private Long profissional;
    private boolean ocupado;

    public HorarioDisponivelDTO(HorarioDisponivelEntity horario){
        BeanUtils.copyProperties(horario, this);
    }
    public HorarioDisponivelDTO(){

    }

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

    public Long getProfissional() {
        return profissional;
    }

    public void setProfissional(Long profissional) {
        this.profissional = profissional;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HorarioDisponivelDTO that = (HorarioDisponivelDTO) o;
        return ocupado == that.ocupado && Objects.equals(id, that.id) && Objects.equals(horario, that.horario) && Objects.equals(profissional, that.profissional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horario, profissional, ocupado);
    }
}
