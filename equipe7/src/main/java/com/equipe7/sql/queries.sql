CREATE DATABASE bemPromotora;

use bemPromotora; 

CREATE TABLE tb_usuario(  
id_usuario INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DO USUARIO', 
ds_login VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUARIO PARA ACESSO AO SISTEMA', 
ds_senha VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUARIO PARA ACESSO AO SISTEMA'     
);

CREATE TABLE tb_pessoa(      
id_pessoa INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CODIGO DA PESSOA',     
nome VARCHAR(70) NOT NULL COMMENT 'NOME DA PESSOA',     
idade INT NOT NULL COMMENT  'IDADE',
sexo CHAR(1) NOT NULL COMMENT 'INFORMAR M OU F',  
tipoDocumento INT NOT NULL COMMENT  'TIPO DE DOCUMENTO1-RG, 2-CPF, 3-CNPJ',
numDocumento VARCHAR(14) NOT NULL COMMENT 'NUMERO DO DOCUMENTO INFORMADO REFERENTE AO TIPO INFORMADO',
dataCadastro DATETIME NOT NULL COMMENT 'DATA DE CADASTRO DO REGISTRO',     
email VARCHAR(80) NOT NULL COMMENT 'EMAIL DA PESSOA',     
telefone VARCHAR(10) NOT NULL COMMENT 'NUMERO DE TELEFONE',     
endereco VARCHAR(200) NOT NULL COMMENT 'DESCRICAO DO ENDERECO',        
id_usuario_cadastro INT NOT NULL COMMENT  'USUARIO LOGADO QUE CADASTROU A PESSOA'  
);

ALTER TABLE tb_pessoa ADD FOREIGN KEY (id_usuario_cadastro) REFERENCES tb_usuario(id_usuario);      

INSERT INTO tb_usuario (ds_login,ds_senha) VALUES('admin','123456');