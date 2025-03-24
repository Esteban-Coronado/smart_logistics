-- Crear la tabla de almacenes (Warehouses)
CREATE TABLE IF NOT EXISTS warehouse (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

-- Crear la tabla de pedidos (Purchases)
CREATE TABLE IF NOT EXISTS purchase (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    purchase_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    warehouse_id BIGINT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse(id)
);

-- Crear la tabla de clientes (Clients) para la autenticación
CREATE TABLE IF NOT EXISTS client (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Insertar datos iniciales para pruebas
INSERT INTO warehouse (name, location) VALUES
('Main Warehouse', 'New York'),
('West Coast Warehouse', 'Los Angeles');

INSERT INTO purchase (product, quantity, purchase_date, status, warehouse_id) VALUES
('Laptop', 10, '2023-10-01 10:00:00', 'PENDING', 1),
('Smartphone', 20, '2023-10-02 11:00:00', 'SHIPPED', 2);

-- Crear la tabla de tiendas (Stores)
CREATE TABLE IF NOT EXISTS store (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    contact_info VARCHAR(255)
    );

-- Actualizar la tabla de pedidos (Purchases) para incluir la relación con tienda
ALTER TABLE purchase ADD COLUMN store_id BIGINT;
ALTER TABLE purchase ADD FOREIGN KEY (store_id) REFERENCES store(id);

-- Insertar datos iniciales para tiendas
INSERT INTO store (name, address, contact_info) VALUES
    ('Downtown Store', 'Main Street 123, New York', '212-555-1234'),
    ('Mall Store', 'Shopping Mall, Los Angeles', '310-555-6789');

-- Actualizar algunas compras existentes para asignarlas a tiendas
UPDATE purchase SET store_id = 1 WHERE id = 1;
UPDATE purchase SET store_id = 2 WHERE id = 2;

-- Insertar clientes iniciales para pruebas (contraseñas cifradas con BCrypt)
-- Contraseña para 'admin': admin123
-- Contraseña para 'client': client123
INSERT INTO client (username, password, role) VALUES
('admin', '$2a$10$8.UnVuG9HHgffUDAlk8qO.uVlB8wIAH1zP7vD8Z5J5n6Jz1ZQzQ1K', 'ADMIN'),
('client', '$2a$10$8.UnVuG9HHgffUDAlk8qO.uVlB8wIAH1zP7vD8Z5J5n6Jz1ZQzQ1K', 'CLIENT');