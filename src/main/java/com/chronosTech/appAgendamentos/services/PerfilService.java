package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.PerfilDTO;
import com.chronosTech.appAgendamentos.entitys.PerfilEntity;
import com.chronosTech.appAgendamentos.repositorys.PerfilRepository;
import jakarta.persistence.PostRemove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class PerfilService {
    @Autowired
    PerfilRepository perfilRepository;


    public List<PerfilDTO> listarTodos(){
        List<PerfilEntity> perfis = perfilRepository.findAll();
        return perfis.stream().map(PerfilDTO::new).toList();
    }


    public PerfilDTO buscarPorId(Long Id){
        PerfilEntity perfil = perfilRepository.findById(Id).get();
        return new PerfilDTO(perfil);

    }

    public void inserir(PerfilDTO perfil){
        PerfilEntity perfilEntity = new PerfilEntity(perfil);
        perfilRepository.save(perfilEntity);
    }

    public PerfilDTO alterar(PerfilDTO perfil){
        PerfilEntity perfilEntity = new PerfilEntity(perfil);

        return new PerfilDTO(perfilRepository.save(perfilEntity));
    }

    public void excluir(Long Id){
        PerfilEntity perfil= perfilRepository.findById(Id).get();
        perfilRepository.delete(perfil);
    }
}
