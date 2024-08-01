// src/components/Order/OrderHistory.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const OrderHistory = () => {
    const [orders, setOrders] = useState([]);

    useEffect(() => {
        const fetchOrders = async () => {
            const userId = 'user-id'; // replace with actual user id
            const response = await axios.get(`http://localhost:8080/api/orders/${userId}`);
            setOrders(response.data);
        };
        fetchOrders();
    }, []);

    return (
        <div>
            <h2>Order History</h2>
            <ul>
                {orders.map(order => (
                    <li key={order.id}>
                        Order ID: {order.id}, Total: ${order.total}, Delivered: {order.delivered ? 'Yes' : 'No'}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default OrderHistory;
