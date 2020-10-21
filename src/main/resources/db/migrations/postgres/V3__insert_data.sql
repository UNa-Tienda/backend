-- ---------
-- Role data
-- ---------
INSERT INTO "public"."role" (role_id, name)
    VALUES (1, 'User'), (2, 'Admin');
ALTER SEQUENCE role_role_id_seq RESTART WITH 3;

-- ---------
-- Person data
-- ---------
INSERT INTO "public"."person" (person_id, role_id, name, username, email, password, photo, location, paypal_id)
VALUES
    (1, 1, 'Person 1', 'test1', 'test1@gmail.com', 'qwertyuiop', 'photo1', 'address1', 'paypal_id1'),
    (2, 1, 'Person 2', 'test2', 'test2@gmail.com', 'qwertyuiop', 'photo2', 'address2', 'paypal_id2'),
    (3, 2, 'Person 3', 'admin', 'admin@gmail.com', 'admin', 'photo3', 'address3', 'paypal_id3');
ALTER SEQUENCE person_person_id_seq RESTART WITH 4;



-- ---------
-- Category data
-- ---------
INSERT INTO "public"."category" (category_id, name, image)
VALUES
    (1, 'Tecnología', 'tecnologia_img'),
    (2, 'Deportes', 'deportes_img'),
    (3, 'Muebles', 'muebles_img'),
    (4, 'Accesorios', 'accesorios_img'),
    (5, 'Belleza', 'belleza_img');
ALTER SEQUENCE category_category_id_seq RESTART WITH 6;



-- ---------
-- Post data
-- ---------
INSERT INTO "public"."post" (post_id, person_id, category_id, title, product_name, image, 
                            description, total_review, price, stock)
VALUES
    (1, 1, 1, 'titulo1', 'producto1', 'https://i.imgur.com/U9vwWso.png', 'description1', 1, 10000, 1),
    (2, 2, 1, 'titulo2', 'producto2', 'https://i.imgur.com/BQyzgjk.jpg', 'description2', 2, 25000, 2),
    (3, 1, 2, 'titulo3', 'producto3', 'https://i.imgur.com/DOhU4yz.jpg', 'description3', 3, 20000, 3),
    (4, 1, 1, 'titulo4', 'producto4', 'https://i.imgur.com/tPXbK56.jpg', 'description4', 3, 15000, 2),
    (5, 1, 1, 'titulo5', 'producto5', 'https://i.imgur.com/ThtoviB.jpg', 'description5', 3, 20000, 2);
    ALTER SEQUENCE post_post_id_seq RESTART WITH 6;




-- ---------
-- Transaction data
-- ---------
INSERT INTO "public"."transaction" (transaction_id, person_id, post_id, stock_price, quantity)
VALUES
    (1, 2, 1, 1, 1);
ALTER SEQUENCE transaction_transaction_id_seq RESTART WITH 2;



-- ---------
-- review data
-- ---------
-- Aqui van los inserts de la tabla review, dependiendo de la cantidad ingresada
-- variar el question_question_id_seq (default 1)
ALTER SEQUENCE review_review_id_seq RESTART WITH 1;



-- ---------
-- question data
-- ---------
-- Aqui van los inserts de la tabla question, dependiendo de la cantidad ingresada
-- variar el question_question_id_seq (default 1)
ALTER SEQUENCE question_question_id_seq RESTART WITH 1;




-- ---------
-- answer data
-- ---------
-- Aqui van los inserts de la tabla Answer, dependiendo de la cantidad ingresada
-- variar el answer_answer_id_seq (default 1)
ALTER SEQUENCE answer_answer_id_seq RESTART WITH 1;



-- ---------
-- cartshop data
-- ---------
-- Aqui van los inserts de la tabla Cartshop, dependiendo de la cantidad ingresada
-- variar el cartshop_cartshop_id_seq (default 1)
ALTER SEQUENCE cartshop_cartshop_id_seq RESTART WITH 1;



-- ---------
-- cartshop_item data
-- ---------
-- Aqui van los inserts de la tabla Cartshop_item, dependiendo de la cantidad ingresada
-- variar el cartshop_item_cartshop_item_id_seq (default 1)
ALTER SEQUENCE cartshop_item_cartshop_item_id_seq RESTART WITH 1;




-- ---------
-- coupon data
-- ---------
-- Aqui van los inserts de la tabla coupon, dependiendo de la cantidad ingresada
-- variar el coupon_coupon_id_seq (default 1)
ALTER SEQUENCE coupon_coupon_id_seq RESTART WITH 1;



