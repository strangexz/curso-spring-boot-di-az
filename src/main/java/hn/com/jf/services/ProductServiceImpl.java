package hn.com.jf.services;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import hn.com.jf.models.Product;
import hn.com.jf.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	@Value("${config.price.tax}")
	private Double tax;

	/* Inyectando por atributo */
//	@Autowired
//	@Qualifier("productFoo")
	private ProductRepository repository;

	/* Inyección por constructor */
//	public ProductServiceImpl(ProductRepository repository) {
	public ProductServiceImpl(@Qualifier("productRepositoryJson") ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll().stream().map(p -> {
			Double priceTax = p.getPrice() * tax;
//			p.setPrice(priceTax.longValue());

//			Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
			Product newProd = (Product) p.clone();

//			p.setPrice(priceTax.longValue());
//			return p;

			newProd.setPrice(priceTax.longValue());
			return newProd;
		}).collect(Collectors.toList());
	}

	@Override
	public Product findById(Long id) {
		return repository.findById(id);
	}

}
