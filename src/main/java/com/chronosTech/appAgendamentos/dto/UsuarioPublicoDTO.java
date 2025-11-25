package com.chronosTech.appAgendamentos.dto;

import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;

import java.util.Base64;
import java.util.List;

public class UsuarioPublicoDTO {
    private Long id; // Agora incluído
    private String nome;
    private String bios;
    private String foto;
    private List<SessaoDTO> horarios;
    // Não inclua email, CPF ou telefone se for restrito

    public UsuarioPublicoDTO(UsuarioEntity usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.bios = usuario.getBios();
        this.foto = usuario.getFoto() != null
                ? Base64.getEncoder().encodeToString(usuario.getFoto())
                : null;

        if (usuario.getHorarios() != null) {
            this.horarios = usuario.getHorarios().stream()
                    .map(SessaoDTO::new)
                    .toList();
        }
    }

    // ----------------------
    // GETTERS E SETTERS
    // ----------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getBios() {
        return bios;
    }

    public void setBios(String bio) {
        this.bios = bio;
    }

    public List<SessaoDTO> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<SessaoDTO> horarios) {
        this.horarios = horarios;
    }
}
