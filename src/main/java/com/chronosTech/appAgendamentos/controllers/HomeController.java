package com.chronosTech.appAgendamentos.controllers;

import com.chronosTech.appAgendamentos.models.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/")
    public String home() {return "home";}

    @GetMapping("/login")
    public String login(){return "login"; }

    @GetMapping("/cadastro")
    public String cadastro(){return "cadastro";}
}
