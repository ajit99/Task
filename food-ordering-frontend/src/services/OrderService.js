import axios from 'axios';

const API_URL = 'http://localhost:8080/api/orders/';

class OrderService {
    checkout(order) {
        return axios.post(API_URL + 'checkout', order);
    }

    getOrderHistory(userId) {
        return axios.get(API_URL + 'history/' + userId);
    }
}

export default new OrderService();
