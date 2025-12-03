
CREATE DATABASE IF NOT EXISTS bookstore_db;

USE bookstore_db;





CREATE TABLE IF NOT EXISTS users (

    id INT AUTO_INCREMENT PRIMARY KEY,

    full_name VARCHAR(100) NOT NULL,

    address VARCHAR(200) NOT NULL,

    phone VARCHAR(20) NOT NULL

);



CREATE TABLE IF NOT EXISTS cart_items (

    id INT AUTO_INCREMENT PRIMARY KEY,

    user_id INT NOT NULL,

    product_name VARCHAR(100) NOT NULL,

    quantity INT NOT NULL DEFAULT 1,

    price DOUBLE NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id)

);

USE bookstore_db;

--  (Authentication
CREATE TABLE IF NOT EXISTS auth_users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL, 
    password_hash VARCHAR(255) NOT NULL   
);
