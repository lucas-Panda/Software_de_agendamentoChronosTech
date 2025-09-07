package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.PermissaoPerfilRecursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoPerfilRecursoRepository extends JpaRepository<PermissaoPerfilRecursoEntity , Long> {
    PermissaoPerfilRecursoEntity findPermissaoPerfilRecursoEntityById(Long Id);
}
