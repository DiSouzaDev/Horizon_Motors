CREATE TABLE IF NOT EXISTS `Usuario` (
	`id_usuario` int AUTO_INCREMENT NOT NULL UNIQUE,
	`nome_usuario` varchar(200) NOT NULL,
	`senha_usuario` varchar(200) NOT NULL,
	`email_usuario` varchar(200) NOT NULL,
	`cpf_usuario` int NOT NULL,
	`telefone_usuario` int NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

CREATE TABLE IF NOT EXISTS `Carro` (
	`id_carro` int AUTO_INCREMENT NOT NULL UNIQUE,
	`marca_carro` varchar(200) NOT NULL,
	`modelo_carro` varchar(200) NOT NULL,
	`ano_carro` int NOT NULL,
	`preco_carro` int NOT NULL,
	`descricao_carro` varchar(200) NOT NULL,
	PRIMARY KEY (`id_carro`)
);

CREATE TABLE IF NOT EXISTS `Agendamento` (
	`id_agendamento` int AUTO_INCREMENT NOT NULL UNIQUE,
	`data_agendamento` varchar(200) NOT NULL,
	`hora_agendamento` int NOT NULL,
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