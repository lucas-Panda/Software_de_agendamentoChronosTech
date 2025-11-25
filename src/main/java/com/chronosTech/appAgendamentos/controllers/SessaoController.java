package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.SessaoDTO;
import com.chronosTech.appAgendamentos.entitys.SessaoEntity;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import com.chronosTech.appAgendamentos.services.SessaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servicos")
@CrossOrigin
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<SessaoDTO> listarTodos(){
        return sessaoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody @Valid SessaoDTO sessaoDTO){
        sessaoService.inserir(sessaoDTO);
    }

    @PutMapping("/{id}")
    public SessaoDTO alterar(
            @PathVariable Long id,
            @RequestBody @Valid SessaoDTO sessaoDTO){
        sessaoDTO.setId(id);
        return sessaoService.alterar(sessaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) throws Throwable {
        sessaoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/me")
    public ResponseEntity<List<SessaoDTO>> listarMeusServicos(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken){
            return ResponseEntity.status(401).build();
        }

        String email = auth.getName();

        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Erro 404 Usuario não encontrado "));

        List<SessaoDTO> minhasSessoes = sessaoService.listarPorUsuario(usuario.getId());

        return ResponseEntity.ok(minhasSessoes);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<SessaoDTO>> listarPorUsuario(@PathVariable Long id){
        List<SessaoDTO> sessoes = sessaoService.listarPorUsuario(id);
        return ResponseEntity.ok(sessoes);
    }

}
