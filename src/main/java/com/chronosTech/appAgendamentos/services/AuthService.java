package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.AcessDTO;
import com.chronosTech.appAgendamentos.dto.AuthenticationDTO;
import com.chronosTech.appAgendamentos.dto.LoginResponseDTO;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UsuarioService usuarioService;

    public LoginResponseDTO login(AuthenticationDTO authDto){
        try {
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(),authDto.getPassword());

            Authentication authentication = authenticationManager.authenticate(userAuth);

            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            UsuarioEntity usuarioEntity =usuarioService.buscarPorEmail(userAuthenticate.getUsername());

            return new LoginResponseDTO(token, usuarioEntity);
        } catch (Exception e){
            e.printStackTrace();
            return new LoginResponseDTO("Acesso negado", null);
        }
    }
}
