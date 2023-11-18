
CREATE TABLE IF NOT EXISTS Book (
    id SERIAL PRIMARY KEY,
    book_name VARCHAR(255),
    page_numbers INT,
    topic VARCHAR(50) CHECK (topic IN ('COMEDY', 'ROMANCE', 'OTHER')),
    release_date DATE,
    author_id INT REFERENCES Author(id)
);

INSERT INTO Book (book_name, page_numbers, topic, release_date, author_id)
VALUES 
    ('Book 1', 200, 'COMEDY', '2023-01-01', 1),
    ('Book 2', 250, 'ROMANCE', '2023-02-15', 2),
    ('Book 3', 180, 'OTHER', '2023-03-20', 1);
