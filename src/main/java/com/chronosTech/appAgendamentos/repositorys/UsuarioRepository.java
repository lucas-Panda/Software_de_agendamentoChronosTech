package com.chronosTech.appAgendamentos.repositorys;

import com.chronosTech.appAgendamentos.models.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity ,Long> {
    UsuarioEntity findUsuarioEntityByid(Long Id);

    UsuarioEntity findUsuarioEntityByEmail(String email);
}
