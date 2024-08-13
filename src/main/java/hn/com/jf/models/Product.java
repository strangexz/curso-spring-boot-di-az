package hn.com.jf.models;

import lombok.Data;

@Data
public class Product {
	private Long id;
	private String name;
	private Long price;

	/* Constructor vacío */
	public Product() {

	}

	/* Constructor */
	public Product(Long id, String name, Long price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			// TODO: handle exception
			return new Product(this.getId(), this.getName(), this.getPrice());
		}
	}
}
