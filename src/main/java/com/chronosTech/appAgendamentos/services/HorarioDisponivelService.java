package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.HorarioDisponivelDTO;
import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.HorarioDisponivelEntity;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.HorarioDisponivelRepository;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioDisponivelService {

    @Autowired
    private HorarioDisponivelRepository horarioDisponivelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<HorarioDisponivelDTO> listarTodos(){
        List<HorarioDisponivelEntity> horarios = horarioDisponivelRepository.findAll();

        return horarios.stream().map(HorarioDisponivelDTO::new).toList();
    }

    public void inserir(HorarioDisponivelDTO horario){
        UsuarioEntity profissional = usuarioRepository.findById(horario.getProfissional())
                .orElseThrow(() -> new RuntimeException("Erro 404"));

        HorarioDisponivelEntity entity = new HorarioDisponivelEntity();
        entity.setHorario(horario.getHorario());
        entity.setProfissional(profissional);
        entity.setOcupado(false);

        horarioDisponivelRepository.save(entity);
    }

    public HorarioDisponivelDTO alterar(HorarioDisponivelDTO horario){
        UsuarioEntity profissional = usuarioRepository.findById(horario.getProfissional())
                .orElseThrow(() -> new RuntimeException("Erro 404: Profissional não encontrado."));

        HorarioDisponivelEntity entity = null;
        try {
            entity = (HorarioDisponivelEntity) horarioDisponivelRepository.findById(horario.getId())
                            .orElseThrow(() -> new RuntimeException("Erro 404 Id Horario"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        entity.setHorario(horario.getHorario());
        entity.setProfissional(profissional);
        entity.setOcupado(horario.isOcupado());

        HorarioDisponivelEntity salvo = (HorarioDisponivelEntity) horarioDisponivelRepository.save(entity);

        HorarioDisponivelDTO resultado = new HorarioDisponivelDTO();
        resultado.setId(salvo.getId());
        resultado.setHorario(salvo.getHorario());
        resultado.setProfissional(salvo.getProfissional().getId());
        resultado.setOcupado(salvo.isOcupado());

        return resultado;
    }

    public void excluir(Long Id) throws Throwable {
        HorarioDisponivelEntity horarioDisponivel = (HorarioDisponivelEntity) horarioDisponivelRepository.findById(Id)
                        .orElseThrow(() ->new RuntimeException("Erro 404 "+ Id +" Não Excluido"));

        horarioDisponivelRepository.delete(horarioDisponivel);
    }

    public HorarioDisponivelDTO buscarPorId(Long Id) throws Throwable {
        HorarioDisponivelEntity horarioDisponivelEntity = (HorarioDisponivelEntity) horarioDisponivelRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Erro 404 Id "+ Id +" Não encontrado"));
        return new HorarioDisponivelDTO(horarioDisponivelEntity);
    }

}
