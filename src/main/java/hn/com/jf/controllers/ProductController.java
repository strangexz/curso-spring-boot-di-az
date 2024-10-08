package hn.com.jf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.com.jf.models.Product;
import hn.com.jf.services.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService service;

	@GetMapping
	public List<Product> list() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Product show(@PathVariable Long id) {
		return service.findById(id);
	}

}
