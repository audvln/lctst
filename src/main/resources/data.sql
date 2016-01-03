INSERT INTO PUBLIC.RESTAURANT (name)  VALUES ('Cili');
INSERT INTO PUBLIC.RESTAURANT (name)  VALUES ('PizzaJazz');

INSERT INTO PUBLIC.MENU_ITEM (description, restaurant, price) VALUES ('pica socioji', 1, 1234);
INSERT INTO PUBLIC.MENU_ITEM (description, restaurant, price) VALUES ('alus', 1,432);
INSERT INTO PUBLIC.MENU_ITEM (description, restaurant, price) VALUES ('kotletas', 2, 6532);

INSERT INTO PUBLIC.USER (name) VALUES ('useris');
INSERT INTO PUBLIC.USER (name) VALUES ('admin');

INSERT INTO PUBLIC.VOTE (userid, restaurant, date) VALUES (1, 2, CURRENT_DATE);
INSERT INTO PUBLIC.VOTE (userid, restaurant, date) VALUES (2, 2, CURRENT_DATE);
