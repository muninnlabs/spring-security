-- Users, Roles, and Authorities tables

CREATE TABLE IF NOT EXISTS roles (
    role_id INT AUTO_INCREMENT PRIMARY KEY,
    role_name ENUM('ROLE_ADMIN','ROLE_USER') NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS users (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(20) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(120),
    account_non_locked BIT DEFAULT 1,
    account_non_expired BIT DEFAULT 1,
    credentials_non_expired BIT DEFAULT 1,
    enabled BIT DEFAULT 1,
    credentials_expiry_date DATE,
    account_expiry_date DATE,
    two_factor_secret VARCHAR(255),
    is_two_factor_enabled BIT DEFAULT 0,
    sign_up_method VARCHAR(255),
    created_date DATETIME(6),
    updated_date DATETIME(6),
    role_id INT,
    CONSTRAINT FK_user_role FOREIGN KEY (role_id) REFERENCES roles(role_id)
);
