DROP TABLE items_transaction;
DROP TABLE products;
DROP TABLE transactions;

CREATE TABLE products(
  UPC varchar(4) NOT NULL,
  description varchar(20),
  price DECIMAL(8,2),
  PRIMARY KEY (UPC)
);

CREATE TABLE transactions(
  transaction_id INTEGER NOT NULL,
  customer_name varchar(20),
  payment_type varchar(10),
  money_paid DECIMAL(8,2),
  credit_card varchar(20),
  PRIMARY KEY (transaction_id)
);

CREATE TABLE items_transaction(
  transaction_item_id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY,
  transaction_id INTEGER NOT NULL,
  UPC varchar(4) NOT NULL,
  quantity INTEGER,
  PRIMARY KEY (transaction_item_id)
);

INSERT INTO products (UPC, description, price) VALUES
('5683', 'Stuffed animal           ', 8.50),
('1111', 'White plain mug          ', 4.99),
('1020', 'LG 4K resolution tv      ', 1287.00);

INSERT INTO transactions (transaction_id, customer_name, payment_type, credit_card) VALUES
(2, 'Ilya Nemtsov', 'CREDIT', '11111');

INSERT INTO transactions (transaction_id, customer_name, payment_type, money_paid) VALUES
(1, 'Peter Cruz', 'CASH', 1300.00),
(3, 'Leire Litwin', 'CHECK', 8.50),
(4, 'Ilya Nemtsov', 'CASH', 2000.00);

INSERT INTO items_transaction (transaction_id, UPC, quantity) VALUES
(1, '1111', 2),
(1, '1020', 1),
(2, '5683', 2),
(3, '5683', 1),
(4, '1111', 5),
(4, '5683', 2),
(4, '1020', 1);
