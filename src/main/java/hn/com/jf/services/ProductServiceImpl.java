package hn.com.jf.services;

import java.util.List;
import java.util.stream.Collectors;

import hn.com.jf.models.Product;

public class ProductServiceImpl implements ProductService {

	private ProductServiceImpl repository = new ProductServiceImpl();

	@Override
	public List<Product> findAll() {
		return repository.findAll().stream().map(p -> {
			Double priceTax = p.getPrice() * 1.25d;
//			p.setPrice(priceTax.longValue());
//			Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
			Product newProd = (Product) p.clone();
			newProd.setPrice(priceTax.longValue());
			return newProd;
		}).collect(Collectors.toList());
	}

	@Override
	public Product findById(Long id) {
		return repository.findById(id);
	}

}
