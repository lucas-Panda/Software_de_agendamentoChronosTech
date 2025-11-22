package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import com.chronosTech.appAgendamentos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private UsuarioDTO usuarioDTO;

    @GetMapping
    public List<UsuarioDTO> listarTodos(){
        return usuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody @Valid UsuarioDTO usuario){
        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDTO alterar(@RequestBody @Valid UsuarioDTO usuario){
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long Id){
        usuarioService.excluir(Id);
        return ResponseEntity.ok().build();
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/me")
    public ResponseEntity<UsuarioEntity> getUsuarioLogado(Authentication authentication){
        String email = authentication.getName();
        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("404 Usuário não encontrado"));
        
        return ResponseEntity.ok(usuario);
    }

    @PutMapping(value = "/{id}/perfil",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UsuarioEntity>atualizarPerfil(
            @PathVariable Long id,
            @RequestPart(value = "foto",required = false)MultipartFile foto,
            @RequestPart(value = "bio",required = false)String bio)throws IOException{
        UsuarioEntity atualizado = usuarioService.salvarAlteracoe(id,foto, bio);
        return ResponseEntity.ok(atualizado);
    }

    @GetMapping("/usuario/me")
    public ResponseEntity<UsuarioDTO> getMeuPerfil(@AuthenticationPrincipal UsuarioEntity usuario){
        UsuarioDTO dto = new UsuarioDTO(usuario);
        return ResponseEntity.ok(dto);
    }


}
