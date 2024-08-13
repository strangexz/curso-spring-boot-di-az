package hn.com.jf.repositories;

import java.util.Arrays;
import java.util.List;

import hn.com.jf.models.Product;

public class ProductRepositoryImpl implements ProductRepository {
	private List<Product> data;

	public ProductRepositoryImpl() {
		this.data = Arrays.asList(new Product(1L, "Memoria Corsair 32", 350L),
				new Product(2L, "CPU Intel Core i9", 8500L), new Product(3L, "Teclado Razer Mini 60%", 180L),
				new Product(4L, "Motherboard Gygabyte", 3500L));
	}
	
	@Override
	public List<Product> findAll(){
		return data;
	}
	
	@Override
	public Product findById(Long id) {
		return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow(null);
	}
}
