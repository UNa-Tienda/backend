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
    (2, 'Alimentos', 'alimentos_img'),
    (3, 'Muebles', 'muebles_img'),
    (4, 'Accesorios', 'accesorios_img');
ALTER SEQUENCE category_category_id_seq RESTART WITH 5;



-- ---------
-- Post data
-- ---------
INSERT INTO "public"."post" (post_id, person_id, category_id, title, product_name, image, 
                            description, total_review, price, stock)
VALUES
    (1, 1, 1, 'titulo1', 'producto1', 'img1', 'description1', 1, 1, 1),
    (2, 2, 1, 'titulo2', 'producto2', 'img2', 'description2', 2, 2, 2),
    (3, 1, 2, 'titulo3', 'producto3', 'img3', 'description3', 3, 3, 3);
    ALTER SEQUENCE post_post_id_seq RESTART WITH 4;




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
INSERT INTO "public"."cartshop" (cartshop_id, person_id, total, state)
VALUES
    (1, 1, 2000, 'active');
ALTER SEQUENCE cartshop_cartshop_id_seq RESTART WITH 2;



-- ---------
-- cartshop_item data
-- ---------
INSERT INTO "public"."cartshop_item" (cartshop_item_id, cartshop_id, post_id, quantity)
VALUES
    (1, 1, 1, 1),
    (2, 1, 2, 2),
    (3, 1, 3, 2);
ALTER SEQUENCE cartshop_item_cartshop_item_id_seq RESTART WITH 4;


-- ---------
-- coupon data
-- ---------
-- Aqui van los inserts de la tabla coupon, dependiendo de la cantidad ingresada
-- variar el coupon_coupon_id_seq (default 1)
ALTER SEQUENCE coupon_coupon_id_seq RESTART WITH 1;



