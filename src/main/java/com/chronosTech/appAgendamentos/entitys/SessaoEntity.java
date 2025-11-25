package com.chronosTech.appAgendamentos.entitys;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Table(name = "CHT_SESSAO")
@Entity
public class SessaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nomeHorario;

    @NotNull
    private LocalDate dataSessao;

    @NotNull
    private LocalTime horaSessao;

    @NotBlank
    @Column(nullable = false)
    private String local;

    @NotNull
    @Positive
    @Column(nullable = false)
    private float preco;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonBackReference
    private UsuarioEntity usuario;

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeHorario() {
        return nomeHorario;
    }

    public void setNomeHorario(String nomeHorario) {
        this.nomeHorario = nomeHorario;
    }

    public LocalDate getDataSessao() {
        return dataSessao;
    }

    public void setDataSessao(LocalDate dataSessao) {
        this.dataSessao = dataSessao;
    }

    public LocalTime getHoraSessao() {
        return horaSessao;
    }

    public void setHoraSessao(LocalTime horaSessao) {
        this.horaSessao = horaSessao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SessaoEntity that = (SessaoEntity) o;
        return Float.compare(preco, that.preco) == 0 && Objects.equals(id, that.id) && Objects.equals(nomeHorario, that.nomeHorario) && Objects.equals(dataSessao, that.dataSessao) && Objects.equals(horaSessao, that.horaSessao) && Objects.equals(local, that.local);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeHorario, dataSessao, horaSessao, local, preco);
    }
}
