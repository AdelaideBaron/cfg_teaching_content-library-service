CREATE DATABASE library;

USE library;

CREATE TABLE books (
  book_id INT AUTO_INCREMENT PRIMARY KEY,
  book_name VARCHAR(255) NOT NULL
);

CREATE TABLE reservations (
  reservation_id INT AUTO_INCREMENT PRIMARY KEY,
  book_id INT NOT NULL,
  reservation_status ENUM('RESERVED', 'AVAILABLE') NOT NULL DEFAULT 'AVAILABLE',
  FOREIGN KEY (book_id) REFERENCES books(book_id) ON DELETE CASCADE
);

INSERT INTO books (book_name)
VALUES
  ('The Lord of the Rings: The Fellowship of the Ring'),
  ('The Lord of the Rings: The Two Towers'),
  ('The Lord of the Rings: The Return of the King'),
  ('The Hitchhiker\'s Guide to the Galaxy'),
  ('Pride and Prejudice'),
  ('To Kill a Mockingbird'),
  ('One Hundred Years of Solitude'),
  ('Frankenstein'),
  ('Moby Dick'),
  ('The Catcher in the Rye');

INSERT INTO reservations (book_id)
SELECT book_id
FROM books;

UPDATE reservations
SET reservation_status = 'RESERVED'
LIMIT 5;