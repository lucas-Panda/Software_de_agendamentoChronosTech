package com.chronosTech.appAgendamentos.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    private String carregarTemplate(String nomeArquivo, String nome, String uuid) throws IOException {
        String template = new String(
                Files.readAllBytes(new ClassPathResource("templates/" + nomeArquivo).getFile().toPath())
        );
        return template.replace("#{nome}", nome).replace("#{uuid}", uuid);
    }


    public String enviarEmailTexto(String destinatario , String assunto , String menssagem){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(remetente);
            simpleMailMessage.setTo(destinatario);
            simpleMailMessage.setSubject(assunto);
            simpleMailMessage.setText(menssagem);
            javaMailSender.send(simpleMailMessage);

            return "Email enviado";
        }catch (Exception e){
            return "Falha ao tentar enviar email" + e.getLocalizedMessage();
        }
    }

    public void enviarEmailVerificacao(String destinatario, String nome, String uuid) {
        try {
            String conteudoHtml = carregarTemplate("verificacaoEmail.html", nome, uuid);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(remetente);
            helper.setTo(destinatario);
            helper.setSubject("Verificação do cadastro");
            helper.setText(conteudoHtml, true);

            javaMailSender.send(message);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException("Erro ao enviar email: " + e.getMessage(), e);
        }
    }
}
