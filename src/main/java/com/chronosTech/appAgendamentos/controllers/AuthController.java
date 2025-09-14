package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.dto.AuthenticationDTO;
import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.services.AuthService;
import com.chronosTech.appAgendamentos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authDto ){
        return ResponseEntity.ok(authService.login(authDto));
    }

    @PostMapping(value = "/cadastro")
    public  ResponseEntity<String> cadastrarUsuario(@RequestBody UsuarioDTO novoUsuario){
        usuarioService.inserirNovoUsuario(novoUsuario);
        return ResponseEntity.ok("Usuário cadastrado com sucesso! Verifique seu email.");
    }

    @GetMapping("/verificarCadastro/{uuid}")
    public String  verificarCadastro(@PathVariable("uuid") String uuid){
        return usuarioService.verificarCadastro(uuid);

    }
}
