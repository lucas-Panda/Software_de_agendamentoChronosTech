package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.AgendamentoDTO;
import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.dto.UsuarioPublicoDTO;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import com.chronosTech.appAgendamentos.services.UserDetailsImpl;
import com.chronosTech.appAgendamentos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity<UsuarioDTO> getUsuarioLogado(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken){
            return ResponseEntity.status(401).build();
        }

        String email = authentication.getName();

        UsuarioEntity usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("404 Usuário não encontrado"));

        return ResponseEntity.ok(new UsuarioDTO(usuario));
    }

    @PutMapping(value = "/{id}/perfil",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<UsuarioEntity>atualizarPerfil(
            @PathVariable Long id,
            @RequestPart(value = "foto",required = false)MultipartFile foto,
            @RequestPart(value = "bios",required = false)String bios)throws IOException{
        UsuarioEntity atualizado = usuarioService.salvarAlteracoe(id,foto, bios);
        return ResponseEntity.ok(atualizado);
    }

    //@GetMapping("/usuario/me")
    //public ResponseEntity<UsuarioDTO> getMeuPerfil(@AuthenticationPrincipal UsuarioEntity usuario){
    //    UsuarioDTO dto = new UsuarioDTO(usuario);
    //    return ResponseEntity.ok(dto);
    //}
    @GetMapping("/lojas")
    public ResponseEntity<List<UsuarioDTO>> listarLojas() {
        List<UsuarioDTO> lojas = usuarioService.listarTodos().stream()
                .filter(UsuarioDTO::isLoja) // filtra apenas os que têm loja = true
                .toList();
        return ResponseEntity.ok(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String emailLogado = null;
        if (authentication != null && authentication.isAuthenticated()
        && !(authentication instanceof AnonymousAuthenticationToken)){
            emailLogado = authentication.getName();
        }


        UsuarioEntity usuarioEntity = usuarioService.buscarEntidadePorId(id);
        if (usuarioEntity == null) {
            return ResponseEntity.notFound().build();
        }

        // Se for o próprio usuário logado
        if (emailLogado != null && usuarioEntity.getEmail().equals(emailLogado)) {
            return ResponseEntity.ok(new UsuarioDTO(usuarioEntity));
        }

        // Senão, retorna apenas dados públicos
        return ResponseEntity.ok(new UsuarioPublicoDTO(usuarioEntity));
    }

    @PostMapping("/agendar")
    public ResponseEntity<AgendamentoDTO> agendarServico(@RequestBody AgendamentoDTO agendamentoDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()
                || authentication instanceof AnonymousAuthenticationToken) {
            return ResponseEntity.status(401).build();
        }

        // Pega o usuário logado do token (email do principal)
        String emailLogado = authentication.getName();
        // Se quiser, pode verificar se idUsuario do DTO bate com emailLogado

        AgendamentoDTO agendamentoCriado = usuarioService.agendarServico(agendamentoDTO);
        return ResponseEntity.ok(agendamentoCriado);
    }
}
