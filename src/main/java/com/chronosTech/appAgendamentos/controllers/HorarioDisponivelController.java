package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.HorarioDisponivelDTO;
import com.chronosTech.appAgendamentos.services.HorarioDisponivelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Horario")
@CrossOrigin
public class HorarioDisponivelController {

    @Autowired
    private HorarioDisponivelService horarioDisponivelService;

    @GetMapping
    public List<HorarioDisponivelDTO> listarTodos(){
        return horarioDisponivelService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody @Valid HorarioDisponivelDTO horarioDisponivel){
        horarioDisponivelService.inserir(horarioDisponivel);
    }

    @PutMapping
    public HorarioDisponivelDTO alterar(@RequestBody @Valid HorarioDisponivelDTO horarioDisponivel){
        return horarioDisponivelService.alterar(horarioDisponivel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id) throws Throwable {
        horarioDisponivelService.excluir(Id);
        return ResponseEntity.ok().build();
    }

}