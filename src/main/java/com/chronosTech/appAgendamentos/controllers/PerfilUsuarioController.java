package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.PerfilUsuarioDTO;
import com.chronosTech.appAgendamentos.services.PerfilUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfilUsuario")
@CrossOrigin
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioService perfilUsuarioService;

    @GetMapping
    public List<PerfilUsuarioDTO> buscarTodos(){
        return perfilUsuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PerfilUsuarioDTO perfilusuario){
        perfilUsuarioService.inserir(perfilusuario);
    }

    @PutMapping
    public PerfilUsuarioDTO alterar(@RequestBody PerfilUsuarioDTO perfilUsuario){
        return perfilUsuarioService.alterar(perfilUsuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id){
        perfilUsuarioService.excluir(Id);
        return ResponseEntity.ok().build();
    }
}
