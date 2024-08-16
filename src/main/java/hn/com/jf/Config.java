package hn.com.jf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import hn.com.jf.repositories.ProductRepository;
import hn.com.jf.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({ @PropertySource("classpath:config.properties") })
public class Config {

	@Bean
	ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson();
	}
}
