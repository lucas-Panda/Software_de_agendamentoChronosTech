package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.PerfilUsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.PerfilUsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;


    public List<PerfilUsuarioDTO> listarTodos(){
        List<PerfilUsuarioEntity> perilUsuario = perfilUsuarioRepository.findAll();
        return perilUsuario.stream().map(PerfilUsuarioDTO:: new).toList();
    }

    public PerfilUsuarioDTO buscarPorId(Long Id){
        PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findById(Id).get();
        return new PerfilUsuarioDTO(perfilUsuario);
    }

    public void inserir(PerfilUsuarioDTO perfilUsuario){
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
        perfilUsuarioRepository.save(perfilUsuarioEntity);
    }

    public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario){
        PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);

        return new PerfilUsuarioDTO(perfilUsuarioRepository.save(perfilUsuarioEntity));
    }

    public void excluir(Long Id){
        PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findById(Id).get();
        perfilUsuarioRepository.delete(perfilUsuario);
    }
}
