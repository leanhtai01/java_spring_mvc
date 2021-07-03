use sales_mngt_db;
-- create stored procedure get history
DELIMITER $$

CREATE PROCEDURE get_history(IN from_date VARCHAR(20), IN to_date VARCHAR(20))
BEGIN
    SELECT customers.id as customer_id, order_id, customers.`name` as customer_name, sum(total) as total_detail, orders.order_date
	FROM (
		select od.quantity * p.price * (100 - od.discount_value) / 100 as total, od.order_id as order_id from order_details od join products p on od.product_id = p.id WHERE od.discount_unit = "PERCENT"
		UNION
		select od.quantity * (p.price -  od.discount_value) as total, od.order_id as order_id from order_details od join products p on od.product_id = p.id WHERE od.discount_unit = "FLAT_CURRENCY"
	) order_detail, orders, customers
	WHERE order_detail.order_id = orders.id and customers.id = orders.customer_id
	GROUP BY order_id
	HAVING order_id in (
		SELECT o.id from orders o WHERE o.order_date >= from_date and o.order_date <= to_date
);
END $$

DELIMITER ;