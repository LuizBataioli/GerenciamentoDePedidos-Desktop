CREATE DATABASE orderdesk;

CREATE TABLE usuarios (
id INT AUTO_INCREMENT NOT NULL,
nome VARCHAR(150),
classe CHAR(1) DEFAULT '',
nascimento DATE,
PRIMARY KEY (id));

CREATE TABLE produtos (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150),
    descricao TEXT,
    preco DECIMAL(10, 2),
    PRIMARY KEY (id)
);

CREATE TABLE ingredientes (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150),
    PRIMARY KEY (id)
);

CREATE TABLE produtos_ingredientes (
    id_produto INT,
    id_ingrediente INT,
    PRIMARY KEY (id_produto, id_ingrediente),
    FOREIGN KEY (id_produto) REFERENCES produtos(id),
    FOREIGN KEY (id_ingrediente) REFERENCES ingredientes(id)
);

CREATE TABLE clientes (
    id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(150),
    email VARCHAR(150),
    telefone VARCHAR(20),
    endereco VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE pedidos (
    id INT AUTO_INCREMENT NOT NULL,
    id_cliente INT,
    data_pedido TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2),
    STATUS VARCHAR (15) DEFAULT 'P',
    PRIMARY KEY (id),
    FOREIGN KEY (id_cliente) REFERENCES clientes(id)
);
CREATE TABLE pedidos_itens (
    id INT AUTO_INCREMENT NOT NULL,
    id_pedido INT,
    id_produto INT,
    quantidade INT,
    preco_unitario DECIMAL(10, 2),
    subtotal DECIMAL(10, 2),
    PRIMARY KEY (id),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id),
    FOREIGN KEY (id_produto) REFERENCES produtos(id)
);

CREATE TABLE descontos (
    id INT AUTO_INCREMENT NOT NULL,
    codigo VARCHAR(20),
    valor DECIMAL(10, 2),
    data_inicio DATE,
    data_fim DATE,
    PRIMARY KEY (id)
);