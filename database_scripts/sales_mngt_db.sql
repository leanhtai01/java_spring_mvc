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
    CONSTRAINT pk_customer PRIMARY KEY(id)
);

-- create table membership_types
CREATE TABLE membership_types (
    id INT NOT NULL AUTO_INCREMENT,
    membership_type VARCHAR(20),
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
    CONSTRAINT pk_product PRIMARY KEY(id)
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
