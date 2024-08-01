import axios from 'axios';

const API_URL = 'http://localhost:8080/api/cart/';

class CartService {
    addToCart(cartItem) {
        return axios.post(API_URL + 'add', cartItem);
    }

    getCartItems(userId) {
        return axios.get(API_URL + userId);
    }
}

export default new CartService();
