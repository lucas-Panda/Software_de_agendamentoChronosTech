package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.RecursoDTO;
import com.chronosTech.appAgendamentos.services.RecursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/recurso")
@CrossOrigin
public class RecursoController {
    @Autowired
    private RecursoService recursoService;

    @GetMapping
    public List<RecursoDTO> listarTodos(){
        return recursoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody RecursoDTO recurso){
        recursoService.inserir(recurso);
    }

    @PutMapping
    public RecursoDTO alterar(@RequestBody RecursoDTO recurso){
        return recursoService.alterar(recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id){
        recursoService.excluir(Id);
        return ResponseEntity.ok().build();
    }
}
