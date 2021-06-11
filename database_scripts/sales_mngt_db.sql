-- File: sales_mngt_db.sql
-- Create and insert data to database sales_mngt_db
-- Author: 1760169 - Le Anh Tai
-- Email: leanhtai01@gmail.com
-- GitHub: https://github.com/leanhtai01

-- drop user and database if not exist
DROP USER IF EXISTS 'admin'@'localhost';
DROP DATABASE IF EXISTS sales_mngt_db;

-- create database, user, and grant all privileges on the database to the user
CREATE DATABASE IF NOT EXISTS sales_mngt_db;
CREATE USER IF NOT EXISTS 'admin'@'localhost' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON sales_mngt_db.* TO 'admin'@'localhost';
FLUSH PRIVILEGES;

-- use database sales_mngt_db
USE sales_mngt_db;

-- create table customers
CREATE TABLE customers (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    phone_number VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    balance DECIMAL(13, 4) NOT NULL,
    membership_type_id INT NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY(id),
    CONSTRAINT unq_customer_phone_number UNIQUE(phone_number),
    CONSTRAINT unq_customer_email UNIQUE(email)
);

-- create table membership_types
CREATE TABLE membership_types (
    id INT NOT NULL AUTO_INCREMENT,
    membership_type VARCHAR(20),
    debt_limit DECIMAL(13, 4) NOT NULL,
    discount_value DECIMAL(13, 4) NOT NULL,
    discount_unit VARCHAR(20) NOT NULL,
    valid_from DATE NOT NULL,
    valid_until DATE NOT NULL,
    CONSTRAINT pk_membership_type PRIMARY KEY(id)
);

-- create table deposits
CREATE TABLE deposits (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    deposit_amount DECIMAL(13, 4),
    balance_before_deposit DECIMAL(13, 4) NOT NULL,
    balance_after_deposit DECIMAL(13, 4) NOT NULL,
    deposit_date DATE NOT NULL,
    CONSTRAINT pk_deposit PRIMARY KEY(id)
);

-- create table withdraws
CREATE TABLE withdraws (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    withdraw_amount DECIMAL(13, 4) NOT NULL,
    balance_before_withdraw DECIMAL(13, 4) NOT NULL,
    balance_after_withdraw DECIMAL(13, 4) NOT NULL,
    withdraw_date DATE NOT NULL,
    CONSTRAINT pk_withdraw PRIMARY KEY(id)
);

-- create table orders
CREATE TABLE orders (
    id INT NOT NULL AUTO_INCREMENT,
    customer_id INT NOT NULL,
    order_date DATE NOT NULL,
    discount_value DECIMAL(13, 4) NOT NULL,
    discount_unit VARCHAR(20) NOT NULL,
    CONSTRAINT pk_order PRIMARY KEY(id)
);

-- create table order_details
CREATE TABLE order_details (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    discount_value DECIMAL(13, 4) NOT NULL,
    discount_unit VARCHAR(20) NOT NULL,
    CONSTRAINT pk_order_detail PRIMARY KEY(order_id, product_id)
);

-- create table products
CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    weight DOUBLE NOT NULL,
    price DECIMAL(13, 4) NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY(id),
    CONSTRAINT unq_product_name_weight UNIQUE(name, weight)
);

-- create table product_discounts
CREATE TABLE product_discounts (
    id INT NOT NULL AUTO_INCREMENT,
    product_id INT NOT NULL,
    discount_value DECIMAL(13, 4) NOT NULL,
    discount_unit VARCHAR(20) NOT NULL,
    valid_from DATE NOT NULL,
    valid_until DATE NOT NULL,
    CONSTRAINT pk_product_discount PRIMARY KEY(id)
);

-- add foreign key to table customers
ALTER TABLE customers
    ADD CONSTRAINT fk_customers_membership_types
    FOREIGN KEY(membership_type_id)
    REFERENCES membership_types(id);

-- add foreign key to table deposits
ALTER TABLE deposits
    ADD CONSTRAINT fk_deposits_customers
    FOREIGN KEY(customer_id)
    REFERENCES customers(id);

-- add foreign key to table withdraws
ALTER TABLE withdraws
    ADD CONSTRAINT fk_withdraws_customers
    FOREIGN KEY(customer_id)
    REFERENCES customers(id);

-- add foreign key to table orders
ALTER TABLE orders
    ADD CONSTRAINT fk_orders_customers
    FOREIGN KEY(customer_id)
    REFERENCES customers(id);

-- add foreign key to table order_details
ALTER TABLE order_details
    ADD CONSTRAINT fk_order_details_orders
    FOREIGN KEY(order_id)
    REFERENCES orders(id);

ALTER TABLE order_details
    ADD CONSTRAINT fk_order_details_products
    FOREIGN KEY(product_id)
    REFERENCES products(id);

-- add foreign key to table product_discounts
ALTER TABLE product_discounts
    ADD CONSTRAINT fk_product_discount_products
    FOREIGN KEY(product_id)
    REFERENCES products(id);

-- insert data into table membership_types
INSERT INTO membership_types(membership_type, debt_limit, discount_value,
                             discount_unit, valid_from, valid_until)
VALUES ('basic', 10000000, 0, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25'),
       ('silver', 20000000, 10, 'PERCENT', '2021-06-11', '2021-07-25'),
       ('gold', 30000000, 1000000, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25'),
       ('platinum', 50000000, 15, 'PERCENT', '2021-06-11', '2021-07-25');

-- insert data into table customers
INSERT INTO customers(name, phone_number, email, balance, membership_type_id)
VALUES ('Nguyễn Văn Vạn', '0913456456', 'nguyenvanvan@gmail.com', 17000000, 1),
       ('Trần Xuân Vinh', '0566774332', 'tranxuanvinh@yahoo.com', 50000000, 2),
       ('Lý Thị Hằng', '0764563762', 'lthang@outlook.com', 10000000, 3),
       ('Võ Văn Thiện', '0876456765', 'vvthien@gmail.com', 25000000, 4),
       ('Lê Thị Linh', '0765345654', 'ltlinh01@gmail.com', 5000000, 1);

-- insert data into table products
INSERT INTO products(name, weight, price)
VALUES ('Phân bón A', 100, 500000),
       ('Phân bón A', 200, 1000000),
       ('Phân bón A', 500, 5000000),
       ('Phân bón B', 100, 200000);

-- insert data into table product_discounts
INSERT INTO product_discounts(product_id, discount_value, discount_unit,
                              valid_from, valid_until)
VALUES (1, 10, 'PERCENT', '2021-06-11', '2021-07-25'),
       (2, 100000, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25'),
       (3, 0, 'PERCENT', '2021-06-11', '2021-07-25'),
       (4, 20000, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25');
