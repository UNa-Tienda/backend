CREATE TABLE IF NOT EXISTS public.post (
    id INT2,
    user_id INT2,
    category_id INT2,
    title TEXT NOT NULL,
    product_name TEXT NOT NULL,
    image TEXT ,
    description TEXT NOT NULL,
    price INT2,
    stock INT2,
    PRIMARY KEY (id)
);