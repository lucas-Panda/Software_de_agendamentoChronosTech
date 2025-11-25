package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long> {

    boolean existsByHorarioId(Long horarioId);
}