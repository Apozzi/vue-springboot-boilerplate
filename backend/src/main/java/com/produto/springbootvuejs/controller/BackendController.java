package com.produto.springbootvuejs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.produto.springbootvuejs.domain.Product;
import com.produto.springbootvuejs.domain.User;
import com.produto.springbootvuejs.dto.ProductDTO;
import com.produto.springbootvuejs.exception.UserNotFoundException;
import com.produto.springbootvuejs.repository.ProductsRepository;
import com.produto.springbootvuejs.repository.UserRepository;

@Controller
@RequestMapping("/api")
public class BackendController {

    public static final String HELLO_TEXT = "Hello!";
    public static final String SECURED_TEXT = "Hello com autenticação!";

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductsRepository productsRepository;

    @ResponseBody
    @RequestMapping(path = "/user/{lastName}/{firstName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public long addNewUser (@PathVariable("lastName") String lastName, @PathVariable("firstName") String firstName) {
        User savedUser = userRepository.save(new User(firstName, lastName));
        return savedUser.getId();
    }

    @ResponseBody
    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable("id") long id) {
        return userRepository.findById(id).map(user -> {
            return user;
        }).orElseThrow(() -> new UserNotFoundException("Usuário " + id + " não foi encontrado."));
    }
    
    @ResponseBody
    @GetMapping(path = "/products")
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
    
    @ResponseBody
    @GetMapping(path = "/product/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        return productsRepository.findById(id).get();
    }
    
    @ResponseBody
    @RequestMapping(path = "/product", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody ProductDTO dto) {
    	Product product = new Product(dto.getDescription(), dto.getProductType(), dto.getSupplierPrice(), dto.getAmount());
        return productsRepository.save(product);
    }
    
    @ResponseBody
    @RequestMapping(path = "/product/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Product editProduct(@PathVariable("id") long id, @RequestBody ProductDTO dto) {
    	Product product = productsRepository.findById(id).get();
    	product.setDescription(dto.getDescription());
    	product.setAmount(dto.getAmount());
    	product.setProductType(dto.getProductType());
    	product.setSupplierPrice(dto.getSupplierPrice());
        return productsRepository.save(product);
    }
    
    @ResponseBody
    @DeleteMapping(path = "/product/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("id") long id) {
        productsRepository.deleteById(id);
    }
    
    @ResponseBody
    @RequestMapping(path = "/hello")
    public String sayHello() {
        return HELLO_TEXT;
    }

    @ResponseBody
    @RequestMapping(path="/secured", method = RequestMethod.GET)
    public String getSecured() {
        return SECURED_TEXT;
    }
}
