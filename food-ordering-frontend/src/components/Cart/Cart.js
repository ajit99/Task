// src/components/Cart/Cart.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Cart = () => {
    const [cart, setCart] = useState({ items: [] });

    useEffect(() => {
        const fetchCart = async () => {
            const userId = 'user-id'; // replace with actual user id
            const response = await axios.get(`http://localhost:8080/api/cart/${userId}`);
            setCart(response.data);
        };
        fetchCart();
    }, []);

    const handleCheckout = async () => {
        const order = {
            userId: 'user-id', // replace with actual user id
            items: cart.items,
            total: cart.items.reduce((total, item) => total + item.quantity * item.price, 0),
            delivered: false
        };
        await axios.post('http://localhost:8080/api/orders', order);
        // redirect to order confirmation page
    };

    return (
        <div>
            <h2>Cart</h2>
            <ul>
                {cart.items.map(item => (
                    <li key={item.itemId}>
                        {item.name} - {item.quantity}
                    </li>
                ))}
            </ul>
            <button onClick={handleCheckout}>Checkout</button>
        </div>
    );
};

export default Cart;
