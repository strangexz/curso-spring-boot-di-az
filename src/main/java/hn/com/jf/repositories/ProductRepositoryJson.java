package hn.com.jf.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import hn.com.jf.models.Product;

public class ProductRepositoryJson implements ProductRepository {

	private List<Product> list;

	public ProductRepositoryJson() {
		Resource resource = new ClassPathResource("jsons/products.json");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			list = Arrays.asList(objectMapper.readValue(resource.getFile(), Product[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public Product findById(Long id) {
		// TODO Auto-generated method stub
		return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
	}

}
