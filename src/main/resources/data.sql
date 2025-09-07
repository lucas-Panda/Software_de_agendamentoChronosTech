INSERT INTO cht_usuario (nome , email,senha ,cpf , numero_telefone)
values ("jose" , "josecarlos@gmail.com" , "1234" , "80602377994", "24998859674");


INSERT INTO cht_recurso (nome , chave)
values ("Tela Cliente" , "1C");

INSERT INTO cht_perfil (descricao)
values ("cliente");

INSERT INTO cht_perfil_usuario (id_usuario , id_perfil)
values (1 , 1);
