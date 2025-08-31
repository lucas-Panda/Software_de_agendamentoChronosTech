package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.RecursoDTO;
import com.chronosTech.appAgendamentos.entitys.RecursoEntity;
import com.chronosTech.appAgendamentos.repositorys.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecursoService {
    @Autowired
    RecursoRepository recursoRepository;

    public List<RecursoDTO> listarTodos(){
        List<RecursoEntity> recursos = recursoRepository.findAll();
        return recursos.stream().map(RecursoDTO:: new).toList();
    }
    public RecursoDTO buscarPorId(Long Id){
        RecursoEntity recurso = recursoRepository.findById(Id).get();
        return new RecursoDTO(recurso);
    }

    public void inserir(RecursoDTO recurso){
        RecursoEntity recursoEntity = new RecursoEntity(recurso);
        recursoRepository.save(recursoEntity);
    }

    public RecursoDTO alterar(RecursoDTO recurso){
        RecursoEntity recursoEntity = new RecursoEntity(recurso);

        return new RecursoDTO(recursoRepository.save(recursoEntity));
    }

    public void excluir(Long Id){
        RecursoEntity recurso = recursoRepository.findById(Id).get();
        recursoRepository.delete(recurso);
    }
}
