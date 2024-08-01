-- User Data
INSERT INTO users (id, email, password, roles) VALUES
  (1, 'john.doe@example.com', 'password123', 'USER'),
  (2, 'jane.smith@example.com', 'password456', 'USER');

-- Item Data
INSERT INTO items (id, name, category, price, stock) VALUES
  (1, 'Apple', 'Fruit', 0.50, 100),
  (2, 'Banana', 'Fruit', 0.30, 150),
  (3, 'Carrot', 'Vegetable', 0.20, 200),
  (4, 'Chicken Breast', 'Non-veg', 5.00, 50),
  (5, 'Whole Wheat Bread', 'Breads', 2.00, 75);

-- Cart Data
-- Assuming each cart item has a cart ID, user ID, item ID, and quantity.
-- Typically, you would create cart items in a separate `cart_items` table.

-- Cart for user with ID 1
INSERT INTO carts (id, user_id) VALUES (1, 1);

-- Cart Items for cart ID 1
INSERT INTO cart_items (cart_id, item_id, quantity) VALUES
  (1, 1, 5),  -- 5 Apples
  (1, 4, 2);  -- 2 Chicken Breasts

-- Order Data
INSERT INTO orders (id, user_id, total, delivered) VALUES
  (1, 1, 12.50, FALSE);  -- Example order for user with ID 1

-- Order Items Data
-- Assuming each order item has an order ID, item ID, and quantity.
-- Typically, you would create order items in a separate `order_items` table.

-- Order Items for order ID 1
INSERT INTO order_items (order_id, item_id, quantity) VALUES
  (1, 1, 5),  -- 5 Apples
  (1, 4, 2);  -- 2 Chicken Breasts
