CREATE TABLE cate(
    id int GENERATED as IDENTITY PRIMARY KEY,
    name nvarchar2(100) NOT NULL UNIQUE,
    image nvarchar2(100),
    status NUMBER DEFAULT 1
)

CREATE TABLE pro(
    id int GENERATED as IDENTITY PRIMARY KEY,
    name nvarchar2(100) NOT NULL UNIQUE,
    price FLOAT NOT NULL,
    image nvarchar2(100),
    status NUMBER DEFAULT 1,
    description CLOB,
    categoryId int,
    foreign key(categoryId) references cate(id)
)

CREATE TABLE roles(
    id INT GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NULL
);

CREATE TABLE users(
    id NUMBER GENERATED AS IDENTITY PRIMARY KEY,
    userName VARCHAR2(50) NOT NULL,
	password VARCHAR2(200) NOT NULL,
	enabled NUMBER NOT NULL,
	fullName NVARCHAR2(50) NULL,
	gender NUMBER NULL,
	birthday DATE NULL,
	address NVARCHAR2(200) NULL,
	email VARCHAR2(100) NULL,
	telephone VARCHAR2(20) NULL
);

CREATE TABLE users_roles(
    id INT GENERATED AS IDENTITY NOT NULL PRIMARY KEY,
    userId INT NOT NULL,
    roleId INT NOT NULL, 
    FOREIGN KEY(userId) REFERENCES users(id),
    FOREIGN KEY(roleId) REFERENCES roles(id)
)

INSERT INTO roles(name) VALUES ('ROLE_ADMIN');
INSERT INTO roles(name)  VALUES ('ROLE_USER');
INSERT INTO users (userName, password, enabled, fullName, gender, birthday, address, email, telephone)
VALUES ('admin', '$2a$12$Nj/u4S19cTuCVXhMmP1JLexUXyQN0IN/5FH//BL5VtyPTfiASCw4W', 1, 'HiChaoCau', 1, TO_DATE('2000-01-15', 'yyyy-mm-dd'), 'ha noi', 'admin@gmail.com', '012345679');
INSERT INTO users (userName, password, enabled, fullName, gender, birthday, address, email, telephone)
VALUES ('user', '$2a$12$0ExjRV72KLJ9dS0pPgvU2.xG82EMEusSaIww0YDtEWQsl/w5nlAvi', 1, 'HiChaoBan', 1, TO_DATE('2000-01-15', 'yyyy-mm-dd'), 'ha noi', 'user@gmail.com', '012345679');

CREATE TABLE cart(
    id INT GENERATED AS IDENTITY PRIMARY KEY,
    quantity INT NOT NULL,
    total Float NOT NULL,
    userId INT NOT NULL,
    productId INT NOT NULL, 
    FOREIGN KEY(userId) REFERENCES users(id),
    FOREIGN KEY(productId) REFERENCES pro(id)
);

CREATE TABLE orders(
     id INT GENERATED AS IDENTITY PRIMARY KEY,
     userId INT NOT NULL,
     status NUMBER DEFAULT 0 NOT NULL,
     shippingMethod NVARCHAR2(100)NOT NULL,
     paymentMethod NVARCHAR2(100) NOT NULL,
     orderNote NVARCHAR2(100) NOT NULL,
     orderDate TIMESTAMP DEFAULT sysdate,
     orderCode NVARCHAR2(100),
     token NVARCHAR2(100) NULL,
     FOREIGN KEY(userId) REFERENCES users(id)
)

CREATE TABLE order_detail(
     id INT GENERATED AS IDENTITY PRIMARY KEY,
     orderId INT NOT NULL,
     productId INT NOT NULL,
     price FLOAT NOT NULL,
     quantity INT NOT NULL,
     FOREIGN KEY(orderId) REFERENCES orders(id),
     FOREIGN KEY(productId) REFERENCES pro(id)
)

