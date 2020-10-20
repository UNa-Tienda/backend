-- ---------
-- Role data
-- ---------
INSERT INTO "public"."role" (role_id, name)
    VALUES (1, 'User'), (2, 'Admin');



-- ---------
-- Person data
-- ---------
INSERT INTO "public"."person" (person_id, role_id, name, username, email, password, photo, location, paypal_id)
VALUES
    (1, 1, 'Person 1', 'test1', 'test1@gmail.com', 'qwertyuiop', 'photo1', 'address1', 'paypal_id1'),
    (2, 1, 'Person 2', 'test2', 'test2@gmail.com', 'qwertyuiop', 'photo2', 'address2', 'paypal_id2'),
    (3, 2, 'Person 3', 'admin', 'admin@gmail.com', 'admin', 'photo3', 'address3', 'paypal_id3');

-- ---------
-- Category data
-- ---------
INSERT INTO "public"."category" (category_id, name, image)
VALUES
    (1, 'Tecnología', 'tecnologia_img'),
    (2, 'Alimentos', 'alimentos_img'),
    (3, 'Muebles', 'muebles_img'),
    (4, 'Accesorios', 'accesorios_img');

-- ---------
-- Post data
-- ---------
INSERT INTO "public"."post" (post_id, person_id, category_id, title, product_name, image, 
                            description, total_review, price, stock)
VALUES
    (1, 1, 1, 'titulo1', 'producto1', 'img1', 'description1', 1, 1, 1),
    (2, 2, 1, 'titulo2', 'producto2', 'img2', 'description2', 2, 2, 2),
    (3, 1, 2, 'titulo3', 'producto3', 'img3', 'description3', 3, 3, 3);
    ALTER SEQUENCE post_post_id_seq RESTART WITH 3;