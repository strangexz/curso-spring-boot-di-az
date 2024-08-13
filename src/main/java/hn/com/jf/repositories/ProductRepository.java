package hn.com.jf.repositories;

import java.util.List;

import hn.com.jf.models.Product;

public interface ProductRepository {
	List<Product> findAll();

	Product findById(Long id);
}
