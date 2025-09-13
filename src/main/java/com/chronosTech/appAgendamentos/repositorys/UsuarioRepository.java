package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity ,Long> {
    UsuarioEntity findUsuarioEntityByid(Long Id);
    Optional<UsuarioEntity> findByEmail(String email);
}
