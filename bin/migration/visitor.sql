-- Création de la table Visitor
CREATE TABLE IF NOT EXISTS Visitor (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    matricule_number VARCHAR(50)
);
INSERT INTO Visitor (username, password, matricule_number)
VALUES 
    ('user1', 'password1', 'M123'),
    ('user2', 'password2', 'F456'),
    ('user3', 'password3', 'O789');
