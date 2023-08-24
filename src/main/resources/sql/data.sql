--INSERT INTO sourcing VALUES ('OMS', 'SEPHORADOTCOM', 'SEPHORAUS', '61321832503', 'CA', 'H1P 1C8', 'QC', 'OMS', 10);

--dummy inset into promise_dates table - We don't need to insert from here
--INSERT INTO promise_dates VALUES ('10', '0801', '-07:00', CURRENT_DATE, CURRENT_DATE, 1, CURRENT_DATE, 'false');


--For Reservation table
INSERT INTO reservation VALUES (1, 'true');


--Inserts into items table

--INSERT INTO items VALUES (10, '38', 'SAMEDAY', '0412', '1', 'locId', '0750', ' ', 'EACH');
--0 quantity insert into items table
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (99, 0, '5000002', 'SHIPTOHOME', '2244689', '0592', '0592', 'NOT_ENOUGH_PRODUCT_CHOICES', 'EACH');

INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (100, 20, '5000002', 'SAMEDAY', '2244689', '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (101, 30, '5000002', 'PICKUP', '2244689', '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (102, 30, '5000002', 'SAMEDAY', '2244689', '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (103, 50, '5000002', 'PICKUP', '2244689', '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (104, 10, '5000002', 'SHIPTOHOME', '2244689', '1050', '1050', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (105, 10, '5000002', 'SHIPTOHOME', '2244689', '0750', '0750', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (106, 10, '5000002', 'SHIPTOHOME', '2244689', '0801', '0801', ' ', 'EACH');

INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (107, 50, '5000002', 'SAMEDAY', '2353613',  '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (108, 50, '5000002', 'PICKUP', '2353613',  '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (109, 50, '5000002', 'SAMEDAY', '2353613',  '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (110, 50, '5000002', 'PICKUP', '2353613',  '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (111, 10, '5000002', 'SHIPTOHOME', '2353613', '1050', '1050', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (112, 10, '5000002', 'SHIPTOHOME', '2353613', '0750', '0750', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (113, 10, '5000002', 'SHIPTOHOME', '2353613', '0801', '0801', ' ', 'EACH');

INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (114, 50, '5000002', 'SAMEDAY', '2314110',  '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (115, 50, '5000002', 'PICKUP', '2314110',  '0592', '0592', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (116, 50, '5000002', 'SAMEDAY', '2314110',  '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (117, 50, '5000002', 'PICKUP', '2314110',  '0034', '0034', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (118, 10, '5000002', 'SHIPTOHOME', '2314110', '1050', '1050', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (119, 10, '5000002', 'SHIPTOHOME', '2314110', '0750', '0750', ' ', 'EACH');
INSERT INTO items (internal_id, quantity, carrier_service_code, fulfillment_type, item_id, location_ids, ship_node, unavailable_reason, uom) VALUES (120, 10, '5000002', 'SHIPTOHOME', '2314110', '0801', '0801', ' ', 'EACH');

--we need to encrypt plain password using bcrypt algo and then insert that directly for new users
INSERT INTO users (user_name, enc_password) VALUES ('avis', '$2a$12$grSUF050gMxJMKBh33IWzOKQO7/W.6b37w8PVHkZ8UkYSPI9BXAXK');
INSERT INTO users (user_name, enc_password) VALUES ('admin', '$2a$10$.KHH/tBblriAEr8xYyAhSOah0kg.v.XaZoIZOc8wFT5urnwqMCpim');