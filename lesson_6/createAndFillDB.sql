BEGIN;

CREATE SCHEMA IF NOT EXISTS market
    AUTHORIZATION postgres;
DROP TABLE IF EXISTS clients_products CASCADE;
DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS products CASCADE;

CREATE TABLE clients (id bigserial PRIMARY KEY, name varchar(255));
INSERT INTO clients (name) VALUES
                               ('Petrov'),
                               ('Ivanov'),
                               ('Sidorov');


CREATE TABLE products (id bigserial PRIMARY KEY, cost numeric(19,2), title varchar(255));
INSERT INTO products (cost, title) VALUES
                                        (100, 'product 1'),
                                        (200, 'product 2'),
                                        (300, 'product 3'),
                                        (400, 'product 4');


CREATE TABLE clients_products (id bigserial PRIMARY KEY, date_ date, client_id bigint, product_id bigint,
    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (product_id) REFERENCES products (id)
);
INSERT INTO clients_products (date_, client_id, product_id) VALUES
                                                                ('01/02/2022', 1, 1),
                                                                ('02/02/2022', 1, 2),
                                                                ('03/02/2022', 2, 1),
                                                                ('04/02/2022', 1, 3),
                                                                ('05/02/2022', 1, 4),
                                                                ('06/02/2022', 2, 4);


COMMIT;





