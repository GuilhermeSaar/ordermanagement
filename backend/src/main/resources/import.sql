-- Inserir dados na tabela tb_client (clientes do supermercado)

INSERT INTO tb_client (name, email, birth_Date) VALUES ('Ana Souza', 'ana.souza@supermercado.com', '1985-04-12');
INSERT INTO tb_client (name, email, birth_Date) VALUES ('Carlos Pereira', 'carlos.pereira@supermercado.com', '1992-08-22');
INSERT INTO tb_client (name, email, birth_Date) VALUES ('Fernanda Lima', 'fernanda.lima@supermercado.com', '1980-11-05');
INSERT INTO tb_client (name, email, birth_Date) VALUES ('José Silva', 'jose.silva@supermercado.com', '1975-01-15');
INSERT INTO tb_client (name, email, birth_Date) VALUES('Patrícia Costa', 'patricia.costa@supermercado.com', '1990-02-28');

-- Inserir dados na tabela tb_product (produtos do supermercado)
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Arroz 5kg', 'Arroz branco, embalagem de 5kg', 19.99, 150);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Feijão Preto 1kg', 'Feijão preto, embalagem de 1kg', 7.49, 200);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Sabão em Pó 1kg', 'Sabão em pó, embalagem de 1kg', 8.99, 60);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Maçã Gala 1kg', 'Maçã Gala, embalagem de 1kg', 6.99, 120);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Macarrão Espaguete 500g', 'Macarrão espaguete, embalagem de 500g', 4.99, 300);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Carne Bovina 1kg', 'Carne bovina, corte de filé mignon, 1kg', 29.90, 50);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Frango Congelado 1kg', 'Frango congelado, embalagem de 1kg', 15.00, 100);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Banana Prata 1kg', 'Banana Prata, embalagem de 1kg', 5.49, 100);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Detergente 500ml', 'Detergente líquido, embalagem de 500ml', 2.49, 80);
INSERT INTO tb_product (name, description, price, quantity_Stock) VALUES ('Leite Integral 1L', 'Leite integral, embalagem de 1 litro', 3.29, 250);


-- Inserir dados na tabela tb_order (pedidos realizados pelos clientes)
INSERT INTO tb_order (order_Data, client_id, total_Value) VALUES ('2023-11-15', 1, 84.23); -- Pedido de Ana Souza
INSERT INTO tb_order (order_Data, client_id, total_Value) VALUES ('2023-10-10', 2, 60.19);  -- Pedido de Carlos Pereira
INSERT INTO tb_order (order_Data, client_id, total_Value) VALUES ('2023-09-05', 3, 120.50); -- Pedido de Fernanda Lima
INSERT INTO tb_order (order_Data, client_id, total_Value) VALUES ('2023-08-20', 4, 45.00);  -- Pedido de José Silva
INSERT INTO tb_order (order_Data, client_id, total_Value) VALUES ('2023-07-30', 5, 98.99);  -- Pedido de Patrícia Costa

-- Inserir dados na tabela tb_order (pedidos realizados pelos clientes)

-- Inserir item 1 - Arroz 5kg no Pedido 1
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(1, 1, 2, 19.99, 39.98);  -- Arroz 5kg

-- Inserir item 2 - Feijão Preto 1kg no Pedido 1
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(2, 1, 1, 7.49, 7.49);   -- Feijão Preto 1kg

-- Inserir item 3 - Maçã Gala 1kg no Pedido 1
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(6, 1, 1, 6.99, 6.99);   -- Maçã Gala 1kg

-- Inserir item 4 - Macarrão Espaguete 500g no Pedido 1
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(3, 1, 2, 4.99, 9.98);   -- Macarrão Espaguete 500g

-- Inserir item 5 - Carne Bovina 1kg no Pedido 2
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(4, 2, 1, 29.90, 29.90); -- Carne Bovina 1kg

-- Inserir item 6 - Frango Congelado 1kg no Pedido 2
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(5, 2, 2, 15.00, 30.00); -- Frango Congelado 1kg

-- Inserir item 7 - Banana Prata 1kg no Pedido 3
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(7, 3, 3, 5.49, 16.47);  -- Banana Prata 1kg

-- Inserir item 8 - Leite Integral 1L no Pedido 3
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(8, 3, 2, 3.29, 6.58);   -- Leite Integral 1L

-- Inserir item 9 - Detergente 500ml no Pedido 4
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(9, 4, 1, 2.49, 2.49);   -- Detergente 500ml

-- Inserir item 10 - Sabão em Pó 1kg no Pedido 5
INSERT INTO tb_orderitem(product_id, order_id, quantity, unit_Price, total_Value) VALUES(10, 5, 3, 8.99, 26.97); -- Sabão em Pó 1kg


                                                                    

