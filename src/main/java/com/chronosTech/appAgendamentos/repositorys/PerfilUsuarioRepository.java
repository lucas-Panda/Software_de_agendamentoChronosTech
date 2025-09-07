package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity , Long> {
        PerfilUsuarioEntity findPerfilUsuarioEntityById(Long Id);
}
