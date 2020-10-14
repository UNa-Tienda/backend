CREATE TABLE IF NOT EXISTS public.person (
    id INT2,
    name TEXT NOT NULL,
    username TEXT NOT NULL,
    email TEXT NOT NULL,
    password TEXT NOT NULL,
    photo TEXT,
    location TEXT,
    PRIMARY KEY (id)
);