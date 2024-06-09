-- drop database horizon_motors;
create database horizon_motors;

use Horizon_Motors;

CREATE TABLE IF NOT EXISTS `Usuario` (
	`id_usuario` int AUTO_INCREMENT NOT NULL UNIQUE,
	`nome_usuario` varchar(200) NOT NULL,
	`senha_usuario` varchar(200) NOT NULL,
    `tipo_usuario` enum('comum', 'admin') NOT NULL DEFAULT 'comum',
	`email_usuario` varchar(200) NOT NULL,
	`cpf_usuario` varchar(11) NOT NULL,
	`telefone_usuario` varchar(12) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE IF NOT EXISTS `Carro` (
	`id_carro` int AUTO_INCREMENT NOT NULL UNIQUE,
	`marca_carro` varchar(200) NOT NULL,
	`modelo_carro` varchar(200) NOT NULL,
	`ano_carro` int NOT NULL,
	`cambio_carro` varchar(200) NOT NULL,
    `potencia_carro` varchar (200) NOT NULL,
    `gasolina_carro` varchar(200) NOT NULL,
	`preco_carro` double NOT NULL,
	`descricao_carro` varchar(200) NOT NULL,
	PRIMARY KEY (`id_carro`)
);

CREATE TABLE IF NOT EXISTS `Agendamento` (
	`id_agendamento` int AUTO_INCREMENT NOT NULL UNIQUE,
	`data_agendamento` date NOT NULL,
	`hora_agendamento` double NOT NULL,
	`id_usuario` int NOT NULL,
	`id_carro` int NOT NULL,
	PRIMARY KEY (`id_agendamento`)
);

CREATE TABLE IF NOT EXISTS `Funcionarios` (
	`id_func` int AUTO_INCREMENT NOT NULL UNIQUE,
	`nome_func` varchar(200) NOT NULL,
	`cargo_func` varchar(200) NOT NULL,
	`id_carro` int NOT NULL,
	PRIMARY KEY (`id_func`)
);

ALTER TABLE `Agendamento` ADD CONSTRAINT `Agendamento_fk3` FOREIGN KEY (`id_usuario`) REFERENCES `Usuario`(`id_usuario`);
ALTER TABLE `Agendamento` ADD CONSTRAINT `Agendamento_fk4` FOREIGN KEY (`id_carro`) REFERENCES `Carro`(`id_carro`);
ALTER TABLE `Funcionarios` ADD CONSTRAINT `Funcionarios_fk3` FOREIGN KEY (`id_carro`) REFERENCES `Carro`(`id_carro`);

select * from Usuario;
select * from Carro;

INSERT INTO Usuario (nome_usuario, senha_usuario, tipo_usuario, email_usuario, cpf_usuario, telefone_usuario) VALUES
('Diogo', '123', 'admin', 'diogo@email.com', 12345678901, 123456789),
('Maria', 'senha456', 'comum', 'maria@email.com', 23456789012, 234567890),
('Pedro', 'senha789', 'comum', 'pedro@email.com', 34567890123, 345678901),
('Ana', 'senhaabc', 'comum', 'ana@email.com', 45678901234, 456789012),
('José', 'senhaxyz', 'comum', 'jose@email.com', 56789012345, 567890123);

INSERT INTO Carro (marca_carro, modelo_carro, ano_carro, cambio_carro, potencia_carro, gasolina_carro, preco_carro, descricao_carro)
VALUES ('Ferrari', 'LaFerrari', 2023, 'Automático', '950 cv', 'Gasolina', 4000000.00, 'Super carro de luxo'),
('Lamborghini', 'Aventador', 2023, 'Automático', '730 cv', 'Gasolina', 3500000.00, 'Exclusivo superesportivo'),
('Bugatti', 'Chiron', 2023, 'Automático', '1500 cv', 'Gasolina', 5000000.00, 'Hypercarro veloz e luxuoso'),
('Rolls-Royce', 'Phantom', 2023, 'Automático', '563 cv', 'Gasolina', 7000000.00, 'Luxo incomparável e conforto supremo'),
('Bentley', 'Mulsanne', 2023, 'Automático', '505 cv', 'Gasolina', 3500000.00, 'Elegância britânica e sofisticação'),
('McLaren', '720S', 2023, 'Automático', '710 cv', 'Gasolina', 2500000.00, 'Esportividade extrema e design arrojado');
