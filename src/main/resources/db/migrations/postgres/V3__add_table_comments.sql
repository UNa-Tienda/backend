CREATE TABLE IF NOT EXISTS comments (
    id INT4,
    comment TEXT NOT NULL,
    author TEXT NOT NULL,
    PRIMARY KEY (id)
);