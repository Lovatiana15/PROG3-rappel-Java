-- Création de la table Author
CREATE TABLE IF NOT EXISTS Author (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    sex CHAR(1) CHECK (sex IN ('M', 'F'))
);

INSERT INTO Author (name, sex)
VALUES 
    ('Author 1', 'M'),
    ('Author 2', 'F');
