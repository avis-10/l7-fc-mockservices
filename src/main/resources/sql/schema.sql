--Sourcing table
CREATE TABLE IF NOT EXISTS sourcing ( transaction_type VARCHAR(20), seller_code VARCHAR(50), enterprise_code VARCHAR(50), cart_id VARCHAR(50), country VARCHAR(10), zip_code VARCHAR(20), state VARCHAR(10), source_system VARCHAR(10), sourcing_id INT AUTO_INCREMENT  PRIMARY KEY );

--Items table
CREATE TABLE IF NOT EXISTS items ( internal_id INT PRIMARY KEY, quantity INT, carrier_service_code VARCHAR(10), fulfillment_type VARCHAR(20), item_id VARCHAR(20), location_ids VARCHAR(100), ship_node VARCHAR(20), unavailable_reason VARCHAR(100), uom VARCHAR(20) );
--CREATE TABLE IF NOT EXISTS items ( quantity INT, carrier_service_code VARCHAR(10), fulfillment_type VARCHAR(20), item_id VARCHAR(20) PRIMARY KEY, line_id VARCHAR(10), location_ids VARCHAR(100), ship_node VARCHAR(20), unavailable_reason VARCHAR(100), uom VARCHAR(20) );

--Promise Table
CREATE TABLE IF NOT EXISTS promise_dates ( carrier_service_code VARCHAR(20), ship_node VARCHAR(100), dc_time_zone VARCHAR(20), shipping_date DATE , delivery_date DATE, delivery_date_type INT, cutoff_timestamp DATE, delay_added VARCHAR(10) );

--For Reservation
CREATE TABLE IF NOT EXISTS reservation ( reservation_id INT PRIMARY KEY, reservation_flag VARCHAR(10) );

--For User AUTHORIZATION
CREATE TABLE IF NOT EXISTS users (user_name VARCHAR(30) PRIMARY KEY, enc_password VARCHAR(500) );