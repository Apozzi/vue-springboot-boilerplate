package com.produto.springbootvuejs.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.produto.springbootvuejs.domain.Product;

public interface ProductsRepository extends CrudRepository<Product, Long> {
	
	@Override
    List<Product> findAll();

}
