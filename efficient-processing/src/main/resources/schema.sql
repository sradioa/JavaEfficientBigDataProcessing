--DROP TABLE products IF EXISTS;

CREATE TABLE IF NOT EXISTS products (
  product_id SERIAL PRIMARY KEY,
  description VARCHAR(100) NOT NULL,
  price DECIMAL(15,2),
  stock integer DEFAULT 0
);
