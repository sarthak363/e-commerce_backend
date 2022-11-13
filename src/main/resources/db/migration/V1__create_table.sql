CREATE TABLE customer (
  customer_id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NULL,
   pin BIGINT NULL,
   CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);