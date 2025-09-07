package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.PerfilUsuarioDTO;
import com.chronosTech.appAgendamentos.dto.PermissaoPerfilRecursoDTO;
import com.chronosTech.appAgendamentos.services.PerfilUsuarioService;
import com.chronosTech.appAgendamentos.services.PermissaoPerfilRecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/permissaoPerfilRecurso")
@CrossOrigin
public class PermissaoPerfilRecursoController {

    @Autowired
    private PermissaoPerfilRecursoService permissaoPerfilRecursoService;

    @GetMapping
    public List<PermissaoPerfilRecursoDTO> buscarTodos(){
        return permissaoPerfilRecursoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        permissaoPerfilRecursoService.inserir(permissaoPerfilRecurso);
    }

    @PutMapping
    public PermissaoPerfilRecursoDTO alterar(@RequestBody PermissaoPerfilRecursoDTO permissaoPerfilRecurso){
        return permissaoPerfilRecursoService.alterar(permissaoPerfilRecurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id){
        permissaoPerfilRecursoService.excluir(Id);
        return ResponseEntity.ok().build();
    }
}
