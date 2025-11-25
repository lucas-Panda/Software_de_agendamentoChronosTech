package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SessaoRepository extends JpaRepository<SessaoEntity, Long> {

    SessaoEntity findSessaoEntityByid(Long id);
    List<SessaoEntity> findByUsuarioId(Long usuarioId);
}
