package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.HorarioDisponivelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HorarioDisponivelRepository extends JpaRepository<HorarioDisponivelEntity, Long> {

    Optional<HorarioDisponivelEntity> findById(Long id);

    HorarioDisponivelEntity findHorarioDisponivelEntityById(Long id);
}
