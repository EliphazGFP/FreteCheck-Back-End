CREATE TABLE postagem (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    usuarioid TEXT NOT NULL REFERENCES Usuarios(id),
    descricao TEXT NOT NULL,
    localOrigem TEXT NOT NULL,
    localDestino TEXT NOT NULL,
    dataColeta DATE NOT NULL,
    fotoCargaUrl TEXT,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);