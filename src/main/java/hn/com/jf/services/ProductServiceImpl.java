package hn.com.jf.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hn.com.jf.models.Product;
import hn.com.jf.repositories.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

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
