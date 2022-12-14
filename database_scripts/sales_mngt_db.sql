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
    discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
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
    discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
    CONSTRAINT pk_order PRIMARY KEY(id)
);

-- create table order_details
CREATE TABLE order_details (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    discount_value DECIMAL(13, 4) NOT NULL,
    discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
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
    discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
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
VALUES ('Nguy???n V??n V???n', '0913456456', 'nguyenvanvan@gmail.com', 17000000, 1),
       ('Tr???n Xu??n Vinh', '0566774332', 'tranxuanvinh@yahoo.com', 50000000, 2),
       ('L?? Th??? H???ng', '0764563762', 'lthang@outlook.com', 10000000, 3),
       ('V?? V??n Thi???n', '0876456765', 'vvthien@gmail.com', 25000000, 4),
       ('L?? Th??? Linh', '0765345654', 'ltlinh01@gmail.com', 5000000, 1);

-- insert data into table products
INSERT INTO products(name, weight, price)
VALUES ('Ph??n b??n A', 100, 500000),
       ('Ph??n b??n A', 200, 1000000),
       ('Ph??n b??n A', 500, 5000000),
       ('Ph??n b??n B', 100, 200000);

-- insert data into table product_discounts
INSERT INTO product_discounts(product_id, discount_value, discount_unit,
                              valid_from, valid_until)
VALUES (1, 10, 'PERCENT', '2021-06-11', '2021-07-25'),
       (2, 100000, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25'),
       (3, 0, 'PERCENT', '2021-06-11', '2021-07-25'),
       (4, 20000, 'FLAT_CURRENCY', '2021-06-11', '2021-07-25');

-- insert data into table orders
INSERT INTO orders(customer_id, order_date, discount_value, discount_unit)
VALUES (1, '2019-05-04', 0, 'FLAT_CURRENCY'),
       (2, '2020-12-12', 10, 'PERCENT'),
       (3, '2021-01-03', 1000000, 'FLAT_CURRENCY'),
       (4, '2018-12-25', 15, 'PERCENT');

-- insert data into table order_details
INSERT INTO order_details(order_id, product_id, quantity, discount_value,
                          discount_unit)
VALUES (1, 1, 1, 10, 'PERCENT'),
       (1, 2, 4, 100000, 'FLAT_CURRENCY'),
       (1, 3, 2, 0, 'PERCENT'),
       (1, 4, 7, 20000, 'FLAT_CURRENCY'),
       (2, 1, 1, 10, 'PERCENT'),
       (2, 4, 1, 20000, 'FLAT_CURRENCY'),
       (3, 2, 10, 100000, 'FLAT_CURRENCY'),
       (4, 3, 5, 0, 'PERCENT'),
       (4, 2, 3, 100000, 'FLAT_CURRENCY');

-- create stored procedure get Customer's detail
DELIMITER $$

CREATE PROCEDURE get_customer_info(IN param_phone_number VARCHAR(50))
BEGIN
    IF (param_phone_number IS NULL)
    THEN
        SELECT c.id, c.name, c.phone_number, c.email, c.balance,
	       c.membership_type_id,
	       (SELECT mst.membership_type
	        FROM membership_types mst
		WHERE mst.id = c.membership_type_id) AS membership_type
	FROM customers c;
    ELSE
        SELECT c.id, c.name, c.phone_number, c.email, c.balance,
	       c.membership_type_id,
	       (SELECT mst.membership_type
	        FROM membership_types mst
		WHERE mst.id = c.membership_type_id) AS membership_type
	FROM customers c
	WHERE c.phone_number = param_phone_number;
    END IF;
END $$

DELIMITER ;

-- create stored procedure insert new Customer
DELIMITER $$

CREATE PROCEDURE insert_customer(IN cust_name VARCHAR(50),
                                 IN cust_phone_number VARCHAR(50),
				 IN cust_email VARCHAR(50),
				 IN cust_balance DECIMAL(13, 4),
				 IN cust_membership_type_id INT,
				 OUT cust_id INT,
				 OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM customers
	 WHERE phone_number = cust_phone_number) > 0)
    THEN
        SET error_code = 1; -- phone number already exist
    ELSE
        IF ((SELECT COUNT(*)
	     FROM customers
	     WHERE email = cust_email) > 0)
	THEN
	    SET error_code = 2; -- email already exists
	ELSE
	    -- insert new user
	    INSERT INTO customers(name, phone_number, email, balance,
	                          membership_type_id)
	    VALUES (cust_name, cust_phone_number, cust_email, cust_balance,
	            cust_membership_type_id);

            SET cust_id = (SELECT LAST_INSERT_ID());
	    SET error_code = 0; -- insert success
	END IF;
    END IF;
END $$

DELIMITER ;

-- create stored procedure update a Customer
DELIMITER $$

CREATE PROCEDURE update_customer(IN cust_id INT,
                                 IN cust_name VARCHAR(50),
                                 IN cust_phone_number VARCHAR(50),
			         IN cust_email VARCHAR(50),
				 IN cust_balance DECIMAL(13, 4),
				 IN cust_membership_type_id INT,
				 OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM customers
	 WHERE phone_number = cust_phone_number AND id != cust_id) > 0)
    THEN
        SET error_code = 1; -- phone number already exist
    ELSE
        IF ((SELECT COUNT(*)
	     FROM customers
	     WHERE email = cust_email AND id != cust_id) > 0)
	THEN
	    SET error_code = 2; -- email already exists
	ELSE
	    IF ((SELECT COUNT(*)
	         FROM customers
		 WHERE id = cust_id) > 0)
	    THEN
	        -- update the Customer
		UPDATE customers
		SET name = cust_name, phone_number = cust_phone_number,
		    email = cust_email, balance = cust_balance,
		    membership_type_id = cust_membership_type_id
		WHERE id = cust_id;

		SET error_code = 0; -- update success
	    ELSE
	        SET error_code = 3; -- customer not exists
	    END IF;
	END IF;
    END IF;
END $$

DELIMITER ;

-- create stored procedure get Customer's id
DELIMITER $$

CREATE PROCEDURE get_customer_id(IN cust_phone_number VARCHAR(50),
                                 OUT cust_id INT,
				 OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM customers
	 WHERE phone_number = cust_phone_number) > 0)
    THEN
        SET cust_id = (SELECT id
	               FROM customers
		       WHERE phone_number = cust_phone_number);
	SET error_code = 0; -- customer found
    ELSE
        SET error_code = 1; -- customer not found
    END IF;
END $$

DELIMITER ;

-- create stored procedure get a Customer by phone number
DELIMITER $$

CREATE PROCEDURE get_customer(IN cust_phone_number VARCHAR(50),
                              OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM customers
	 WHERE phone_number = cust_phone_number) > 0)
    THEN
	SET error_code = 0; -- customer found
    ELSE
        SET error_code = 1; -- customer not found
    END IF;

    SELECT c.id, c.name, c.phone_number, c.email, c.balance,
	   c.membership_type_id,
	   (SELECT mst.membership_type
	    FROM membership_types mst
            WHERE mst.id = c.membership_type_id) AS membership_type
    FROM customers c
    WHERE c.phone_number = cust_phone_number;
END $$

DELIMITER ;

-- create stored procedure get a Customer by id
DELIMITER $$

CREATE PROCEDURE get_customer_by_id(IN cust_id INT,
                                    OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM customers
	 WHERE id = cust_id) > 0)
    THEN
	SET error_code = 0; -- customer found
    ELSE
        SET error_code = 1; -- customer not found
    END IF;

    SELECT c.id, c.name, c.phone_number, c.email, c.balance,
	   c.membership_type_id,
	   (SELECT mst.membership_type
	    FROM membership_types mst
            WHERE mst.id = c.membership_type_id) AS membership_type
    FROM customers c
    WHERE c.id = cust_id;
END $$

DELIMITER ;

-- create stored procedure insert new Order
DELIMITER $$

CREATE PROCEDURE insert_order(OUT order_id INT,
                              IN param_customer_id INT,
                              IN param_order_date DATE,
			      IN param_discount_value DECIMAL(13, 4),
			      IN param_discount_unit ENUM('PERCENT',
			                                  'FLAT_CURRENCY'))
BEGIN
    INSERT INTO orders(customer_id, order_date, discount_value, discount_unit)
    VALUES (param_customer_id, param_order_date, param_discount_value,
            param_discount_unit);

    SET order_id = (SELECT LAST_INSERT_ID());
END $$

DELIMITER ;

-- create stored procedure insert new orderDetail
DELIMITER $$

CREATE PROCEDURE insert_order_detail(IN param_order_id INT,
                                     IN param_product_id INT,
				     IN param_quantity INT,
				     IN param_discount_value DECIMAL(13, 4),
				     IN param_discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'))
BEGIN
    INSERT INTO order_details(order_id, product_id, quantity, discount_value,
                              discount_unit)
    VALUES (param_order_id, param_product_id, param_quantity,
            param_discount_value, param_discount_unit);
END $$

DELIMITER ;

-- create stored procedure insert withdraw
DELIMITER $$

CREATE PROCEDURE insert_withdraw(IN param_customer_id INT,
                                 IN param_withdraw_amount DECIMAL(13, 4),
				 IN param_balance_before_withdraw DECIMAL(13, 4),
				 IN param_balance_after_withdraw DECIMAL(13, 4),
				 IN param_withdraw_date DATE)
BEGIN
    INSERT INTO withdraws(customer_id, withdraw_amount, balance_before_withdraw,
                          balance_after_withdraw, withdraw_date)
    VALUES (param_customer_id, param_withdraw_amount, param_balance_before_withdraw,
            param_balance_after_withdraw, param_withdraw_date);
END $$

DELIMITER ;

-- create stored procedure update customer's balance
DELIMITER $$

CREATE PROCEDURE update_customer_balance(IN cust_id INT,
                                         IN cust_balance DECIMAL(13, 4))
BEGIN
    UPDATE customers
    SET balance = cust_balance
    WHERE id = cust_id;
END $$

DELIMITER ;

-- create stored procedure insert new Membership Type
DELIMITER $$

CREATE PROCEDURE insert_membership_type(IN param_membership_type VARCHAR(20),
                                        IN param_debt_limit DECIMAL(13, 4),
					IN param_discount_value DECIMAL(13, 4),
					IN param_discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
					IN param_valid_from DATE,
					IN param_valid_until DATE,
					OUT membership_type_id INT,
					OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM membership_types
	 WHERE LOWER(membership_type) = LOWER(param_membership_type)) > 0)
    THEN
        SET error_code = 1; -- membership type already exists
    ELSE
        -- insert new membership type
	INSERT INTO membership_types(membership_type, debt_limit,
	                             discount_value, discount_unit, valid_from,
				     valid_until)
	VALUES (param_membership_type, param_debt_limit, param_discount_value,
	        param_discount_unit, param_valid_from, param_valid_until);

        SET membership_type_id = (SELECT LAST_INSERT_ID());
	SET error_code = 0; -- insert success
    END IF;
END $$

DELIMITER ;

-- create stored procedure update a Membership Type
DELIMITER $$

CREATE PROCEDURE update_membership_type(IN param_id INT,
                                        IN param_membership_type VARCHAR(20),
					IN param_debt_limit DECIMAL(13, 4),
					IN param_discount_value DECIMAL(13, 4),
					IN param_discount_unit ENUM('PERCENT', 'FLAT_CURRENCY'),
					IN param_valid_from DATE,
					IN param_valid_until DATE,
					OUT error_code INT)
BEGIN
    IF ((SELECT COUNT(*)
         FROM membership_types
	 WHERE LOWER(membership_type) = LOWER(param_membership_type)
	       AND id != param_id) > 0)
    THEN
        SET error_code = 1; -- membership type already exists
    ELSE
        IF ((SELECT COUNT(*)
	     FROM membership_types
	     WHERE id = param_id) > 0)
	THEN
	    -- update the membership type
	    UPDATE membership_types
	    SET membership_type = param_membership_type,
	        debt_limit = param_debt_limit,
		discount_value = param_discount_value,
		discount_unit = param_discount_unit,
		valid_from = param_valid_from,
		valid_until = param_valid_until
	    WHERE id = param_id;

            SET error_code = 0; -- update success
	ELSE
	    SET error_code = 3; -- membership type not exists
	END IF;
    END IF;
END $$

DELIMITER ;
