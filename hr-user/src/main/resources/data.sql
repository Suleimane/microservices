INSERT INTO tb_user (name, email, password) VALUES ('Iris', 'iris@gmail.com', '$2a$10$M1MBPRu2vQddvXRVNRfzK.THa1t9rLFY/e7tK8BET7c03naZeLuye');
INSERT INTO tb_user (name, email, password) VALUES ('Ruth', 'ruth@gmail.com', '$2a$10$M1MBPRu2vQddvXRVNRfzK.THa1t9rLFY/e7tK8BET7c03naZeLuye');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);