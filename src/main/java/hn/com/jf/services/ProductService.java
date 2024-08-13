package hn.com.jf.services;

import java.util.List;

import hn.com.jf.models.Product;

public interface ProductService {
	List<Product> findAll();

	Product findById(Long id);

}
