package com.chronosTech.appAgendamentos.services;

import com.chronosTech.appAgendamentos.dto.SessaoDTO;
import com.chronosTech.appAgendamentos.entitys.SessaoEntity;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.repositorys.SessaoRepository;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {
    private SessaoRepository sessaoRepository;

    private UsuarioRepository usuarioRepository;

    @Autowired
    public SessaoService(SessaoRepository sessaoRepository, UsuarioRepository usuarioRepository) {
        this.sessaoRepository = sessaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<SessaoDTO> listarTodos(){
        return sessaoRepository.findAll()
                .stream().map(SessaoDTO::new).toList();
    }

    public SessaoDTO inserir(SessaoDTO dto){
        SessaoEntity entity = new SessaoEntity();

        entity.setNomeHorario(dto.getNomeHorario());
        entity.setDataSessao(dto.getDataSessao());
        entity.setHoraSessao(dto.getHoraSessao());
        entity.setLocal(dto.getLocal());
        entity.setPreco(dto.getPreco());

        UsuarioEntity usuario = usuarioRepository.findById(dto.getIdPerfil())
                .orElseThrow(()-> new RuntimeException("Erro 404 usuario não encontrado"));
        entity.setUsuario(usuario);

        SessaoEntity salvo = sessaoRepository.save(entity);
        return new SessaoDTO(salvo);
    }

    public SessaoDTO alterar(SessaoDTO dto){
        SessaoEntity entity = sessaoRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada."));

        entity.setNomeHorario(dto.getNomeHorario());
        entity.setDataSessao(dto.getDataSessao());
        entity.setHoraSessao(dto.getHoraSessao());
        entity.setLocal(dto.getLocal());
        entity.setPreco(dto.getPreco());

        return new SessaoDTO(sessaoRepository.save(entity));
    }

    public void excluir(Long id){
        SessaoEntity sessao = sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada."));
        sessaoRepository.delete(sessao);
    }

    public SessaoDTO buscarPorId(Long id){
        SessaoEntity sessao = sessaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada."));
        return new SessaoDTO(sessao);
    }

    public List<SessaoDTO> listarPorUsuario(Long idUsuario){
        List<SessaoEntity> lista = sessaoRepository.findByUsuarioId(idUsuario);
        return lista.stream().map(SessaoDTO::new).toList();
    }

}
