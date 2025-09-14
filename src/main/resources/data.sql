-- Inserção de usuários
INSERT INTO cht_usuario (nome, email, senha, cpf, numero_telefone, situacao)
VALUES
('Jose', 'josecarlos@gmail.com', '1234', '80602377994', '24998859674', 'ATIVO'),
('Marcos', 'marcos@gmail.com', '$1$phyiKs0a$VR9UeSoPqouHrD3AQCB9I1', '29861279326', '24998859675', 'PENDENTE');

-- Inserção de recursos
INSERT INTO cht_recurso (nome, chave)
VALUES
('Tela Cliente', '1C');

-- Inserção de perfis
INSERT INTO cht_perfil (descricao)
VALUES
('cliente');

-- Vinculação de usuários e perfis
INSERT INTO cht_perfil_usuario (id_usuario, id_perfil)
VALUES
(1, 1),
(2, 1);
