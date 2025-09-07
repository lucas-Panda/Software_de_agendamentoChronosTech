package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.PerfilUsuarioDTO;
import com.chronosTech.appAgendamentos.dto.PermissaoPerfilRecursoDTO;
import com.chronosTech.appAgendamentos.entitys.PerfilUsuarioEntity;
import com.chronosTech.appAgendamentos.entitys.PermissaoPerfilRecursoEntity;
import com.chronosTech.appAgendamentos.repositorys.PermissaoPerfilRecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissaoPerfilRecursoService {

    @Autowired
    private PermissaoPerfilRecursoRepository permissaoPerfilRecursoRepository;


    public List<PermissaoPerfilRecursoDTO> listarTodos(){
        List<PermissaoPerfilRecursoEntity> permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findAll();

        return permissaoPerfilRecurso.stream().map(PermissaoPerfilRecursoDTO::new).toList();
    }

    public PermissaoPerfilRecursoDTO buscarPorId(Long Id){
        PermissaoPerfilRecursoEntity permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findById(Id).get();
        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecurso);
    }

    public void inserir(PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);
        permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity);
    }

    public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        PermissaoPerfilRecursoEntity permissaoPerfilRecursoEntity = new PermissaoPerfilRecursoEntity(permissaoPerfilRecurso);

        return new PermissaoPerfilRecursoDTO(permissaoPerfilRecursoRepository.save(permissaoPerfilRecursoEntity));
    }

    public void excluir(Long Id){
        PermissaoPerfilRecursoEntity permissaoPerfilRecurso = permissaoPerfilRecursoRepository.findById(Id).get();
        permissaoPerfilRecursoRepository.delete(permissaoPerfilRecurso);
    }
}
