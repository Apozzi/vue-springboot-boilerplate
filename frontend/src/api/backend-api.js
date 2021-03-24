import axios from 'axios'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 1000
});

export default {
    hello() {
        return AXIOS.get(`/hello`);
    },
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName) {
        return AXIOS.post(`/user/` + firstName + '/' + lastName);
    },
    getAllProducts() {
        return AXIOS.get(`/products`);
    },
    getProduct(id) {
        return AXIOS.get(`/product/${id}`);
    },
    deleteProduct(id) {
        return AXIOS.delete(`/product/${id}`);
    },
    addProduct(product) {
        return AXIOS.post(`/product`, product);
    },
    editProduct(id, product) {
        return AXIOS.put(`/product/${id}`, product);
    },
    getSecured(user, password) {
        return AXIOS.get(`/secured/`,{
            auth: {
                username: user,
                password: password
            }});
    }
}


