package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;

public class LoginResponseDTO {

    private String token;
    private UsuarioEntity usuario;

    public LoginResponseDTO(String token, UsuarioEntity usuario){
        this.token = token;
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
