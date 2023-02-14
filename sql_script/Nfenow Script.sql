CREATE database nfenow;

CREATE TABLE nfe (
    cnpj VARCHAR(255),
    endereco VARCHAR(255),
    razao_social VARCHAR(255),
    valor DECIMAL,
    numero_nota BIGINT AUTO_INCREMENT,
    numero_serie INT,
    PRIMARY KEY (numero_nota)
);