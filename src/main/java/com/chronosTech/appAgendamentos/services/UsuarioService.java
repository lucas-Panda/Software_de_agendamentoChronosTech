package com.chronosTech.appAgendamentos.services;


import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    // CRUD
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Get All ou Listar do todos(READ)
    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    // CREATE ou adicionar/insert
    public void inserir(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    //UPDATE ou alterar/atualizar
    public UsuarioDTO alterar(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);

        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    //DELETE ou excluir/deletar
    public void excluir(Long Id){
        UsuarioEntity usuario = usuarioRepository.findById(Id).get();
        usuarioRepository.delete(usuario);
    }

    //Get one
    public  UsuarioDTO buscarPorId(Long Id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(Id).get();
        return new UsuarioDTO(usuarioEntity);

    }


}
