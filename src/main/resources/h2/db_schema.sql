
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS brand;
DROP TABLE IF EXISTS goods;

CREATE TABLE category (
    category_no INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(255) NOT NULL,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE brand (
    brand_no INT PRIMARY KEY AUTO_INCREMENT,
    brand_name VARCHAR(255) NOT NULL,
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE goods (
    goods_no INT PRIMARY KEY AUTO_INCREMENT,
    brand_no INT NOT NULL,
    category_no INT NOT NULL,
    goods_name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    status VARCHAR(10) DEFAULT 'NEW',
    created_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_goods_1 ON goods (category_no, brand_no);
CREATE INDEX idx_goods_2 ON goods (price);