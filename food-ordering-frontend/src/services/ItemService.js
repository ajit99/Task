import axios from 'axios';

const API_URL = 'http://localhost:8080/api/items/';

class ItemService {
    getItemsByCategory(category) {
        return axios.get(API_URL + 'category/' + category);
    }
}

export default new ItemService();
