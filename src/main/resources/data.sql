-- 0. Desativar checagem de chaves estrangeiras temporariamente
--SET FOREIGN_KEY_CHECKS=0;

-- 1. Limpar tabelas filhas primeiro (tabelas com chaves estrangeiras)
--DELETE FROM cht_perfil_usuario;
--DELETE FROM cht_usuario_verificador;

-- 2. Limpar a tabela pai (tabela referenciada)
--DELETE FROM cht_usuario;

-- 3. Reativar checagem de chaves estrangeiras
--SET FOREIGN_KEY_CHECKS=1;

-- 4. Inserir dados novamente (SEM loja) //Loja, Bios, data_criação
--INSERT INTO cht_usuario (nome, email, senha, cpf, numero_telefone, situacao, loja, bios, data_cadastro)
    --VALUES ('Jose', 'josecarlos@gmail.com', '1234', '80602377994', '24998859674', 'ATIVO', false, 'Carai menó', NOW()),
       --('Marcos', 'marcos@gmail.com', '$1$phyiKs0a$VR9UeSoPqouHrD3AQCB9I1', '29861279326', '24998859675', 'PENDENTE', true, 'Carai menó', NOW());

-- 5. Inserir dados nas tabelas filhas
-- INSERT INTO cht_perfil_usuario (id_usuario, perfil) VALUES (1, 'ROLE_USUARIO');
