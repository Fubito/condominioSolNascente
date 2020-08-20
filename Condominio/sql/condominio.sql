use condominio;

CREATE TABLE Funcionarios (
Id_Funcionario INTEGER NOT NULL AUTO_INCREMENT,
Nome VARCHAR(10) NOT NULL,
Telefone VARCHAR(15),
Id_Cargo INTEGER NOT NULL,
PRIMARY KEY(Id_Funcionario)
);

CREATE TABLE AchadosEPerdidos(
Id_AchadosEPerdidos INTEGER NOT NULL AUTO_INCREMENT,
itemAchado VARCHAR(50) NOT NULL,
Id_Funcionario INTEGER NOT NULL,
FOREIGN KEY(Id_Funcionario) REFERENCES Funcionarios (Id_Funcionario),
PRIMARY KEY(Id_AchadosEPerdidos)
);
 
CREATE TABLE Reservas (
Id_Reserva INTEGER NOT NULL AUTO_INCREMENT,
Dia VARCHAR(10) NOT NULL,
Reserva VARCHAR(30) NOT NULL,
Id_Condomino INTEGER NOT NULL,
PRIMARY KEY(Id_Reserva)
);

CREATE TABLE Cargos (
Id_Cargo INTEGER NOT NULL AUTO_INCREMENT,
NomeDoCargo VARCHAR(30) NOT NULL,
PRIMARY KEY(Id_Cargo)
);

CREATE TABLE Ocorrencias (
Id_Ocorrencia INTEGER NOT NULL AUTO_INCREMENT,
Dia VARCHAR(10) NOT NULL,
Ocorrencia VARCHAR(50) NOT NULL,
Id_Condomino INTEGER NOT NULL,
PRIMARY KEY(Id_Ocorrencia)
);

CREATE TABLE Condomino (
Id_Condomino INTEGER NOT NULL AUTO_INCREMENT,
Nome VARCHAR(50) NOT NULL,
Ap VARCHAR(4) NOT NULL,
Telefone VARCHAR(15),
PRIMARY KEY(Id_Condomino)
);

 
ALTER TABLE Funcionarios ADD FOREIGN KEY(Id_Cargo) REFERENCES Cargos (Id_Cargo);
ALTER TABLE Reservas ADD FOREIGN KEY(Id_Condomino) REFERENCES Condomino (Id_Condomino);
ALTER TABLE Ocorrencias ADD FOREIGN KEY(Id_Condomino) REFERENCES Condomino (Id_Condomino);

INSERT INTO funcionarios (`Nome`, `Telefone` ,`Id_Cargo`) 
VALUES ('Terry', '(88)98888-8888', 4 );
 


