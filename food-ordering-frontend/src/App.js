// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Login from './components/Auth/Login';
import Register from './components/Auth/Register';
import ItemList from './components/Item/ItemList';
import Cart from './components/Cart/Cart';
import OrderHistory from './components/Order/OrderHistory';

const App = () => {
    return (
        <Router>
            <div>
                <Routes>
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                    <Route path="/items" element={<ItemList />} />
                    <Route path="/cart" element={<Cart />} />
                    <Route path="/orders" element={<OrderHistory />} />
                </Routes>
            </div>
        </Router>
    );
};

export default App;
