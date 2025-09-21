package com.chronosTech.appAgendamentos.services;


import com.chronosTech.appAgendamentos.dto.UsuarioDTO;
import com.chronosTech.appAgendamentos.entitys.UsuarioEntity;
import com.chronosTech.appAgendamentos.entitys.UsuarioVerificadorEntity;
import com.chronosTech.appAgendamentos.entitys.enums.TipoSituacaoUsuario;
import com.chronosTech.appAgendamentos.repositorys.UsuarioRepository;
import com.chronosTech.appAgendamentos.repositorys.UsuarioVerificadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {
    // CRUD
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioVerificadorRepository usuarioVerificadorRepository;

    @Autowired
    private EmailService emailService;

    // Get All ou Listar do todos(READ)
    public List<UsuarioDTO> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    // CREATE ou adicionar/insert
    public void inserir(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuarioEntity);
    }

    //UPDATE ou alterar/atualizar
    public UsuarioDTO alterar(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    //DELETE ou excluir/deletar
    public void excluir(Long Id){
        UsuarioEntity usuario = usuarioRepository.findById(Id).get();
        usuarioRepository.delete(usuario);
    }

    //Get one
    public  UsuarioDTO buscarPorId(Long Id){
        UsuarioEntity usuarioEntity = usuarioRepository.findById(Id).get();
        return new UsuarioDTO(usuarioEntity);

    }

    //Metodo para o acesso publico do site
    public void inserirNovoUsuario(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);

        UsuarioVerificadorEntity verificador =  new UsuarioVerificadorEntity();
        verificador.setUsuario(usuarioEntity);
        verificador.setUuid(UUID.randomUUID());
        verificador.setDataExpiracao(Instant.now().plusMillis(900000));
        usuarioVerificadorRepository.save(verificador);

        //TO do -Enviar um e-mail para verficar a conta
        //emailService.enviarEmailTexto(usuario.getEmail(),"Novo usuário cadastrado",
        //        "Você esta recebendo um email de cadastro o numero para validação é " + verificador.getUuid());
        emailService.enviarEmailVerificacao(usuario.getEmail(), usuario.getNome(), verificador.getUuid().toString());


    }

    public String verificarCadastro(String uuid){
        UsuarioVerificadorEntity usuarioVerificacao =  usuarioVerificadorRepository.findByUuid(UUID.fromString(uuid)).get();

        if(usuarioVerificacao != null){
            if(usuarioVerificacao.getDataExpiracao().compareTo(Instant.now()) >= 0){
                UsuarioEntity usuario = usuarioVerificacao.getUsuario();
                usuario.setSituacao(TipoSituacaoUsuario.ATIVO);
                usuarioRepository.save(usuario);

                return "Usuario Verificado com Sucesso!!";
            }else{
                usuarioVerificadorRepository.delete(usuarioVerificacao);
                return "Tempo de verificação expirado";
            }
        }else{
            return "Usuario não Verificado";
        }
    }


    //UPDATE ou alterar/atualizar
    //public UsuarioDTO alterar(UsuarioDTO usuario){
    //    UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
    //    usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
    //    return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    //}

    //DELETE ou excluir/deletar
    //public void excluir(Long Id){
    //    UsuarioEntity usuario = usuarioRepository.findById(Id).get();
    //    usuarioRepository.delete(usuario);
    //}

    //Get one
    //public  UsuarioDTO buscarPorId(Long Id){
    //   UsuarioEntity usuarioEntity = usuarioRepository.findById(Id).get();
    //    return new UsuarioDTO(usuarioEntity);

    //}


}
