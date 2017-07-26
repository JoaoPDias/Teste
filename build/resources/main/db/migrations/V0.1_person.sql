CREATE TABLE person (
  id SERIAL4 PRIMARY KEY,
  nome VARCHAR(200) NOT NULL,
  matricula VARCHAR(50) NOT NULl,
  email VARCHAR(200) NOT NULL,
  dt_nascimento DATE
);