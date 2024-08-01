// src/services/api.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api';

export const register = (email, password) => axios.post(`${API_URL}/auth/register`, { email, password });
export const login = (email, password) => axios.post(`${API_URL}/auth/login`, { email, password });
export const getItems = () => axios.get(`${API_URL}/items`);
export const getCart = userId => axios.get(`${API_URL}/cart/${userId}`);
export const updateCart = (userId, cart) => axios.post(`${API_URL}/cart/${userId}`, cart);
export const placeOrder = order => axios.post(`${API_URL}/orders`, order);
export const getOrders = userId => axios.get(`${API_URL}/orders/${userId}`);
