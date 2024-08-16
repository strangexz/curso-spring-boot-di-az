package hn.com.jf.repositories;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import hn.com.jf.models.Product;

//@Primary
@Repository("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return Collections.singletonList(new Product(1L, "Monitor Asus 27", 600L));
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return new Product(id, "Monitor Asus 27", 600L);
	}

}
