package com.zaradev.ProductSpringData;

import com.zaradev.ProductSpringData.entities.Product;
import com.zaradev.ProductSpringData.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductSpringDataApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product(null, "Computer", 4300,3));
		productRepository.save(new Product(null, "Printer", 1200,4));
		productRepository.save(new Product(null, "Smart phone", 3200,23));

		List<Product> products = productRepository.findAll();

		products.forEach(p -> {
			System.out.println(p.toString());
		});

		Product product = productRepository.findById(Long.valueOf(1)).get();

		System.out.println("************1***************");
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getQuantity());

		System.out.println("*************2**************");
		List<Product> productList = productRepository.findByNameContains("C");
		productList.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("*************3**************");
		List<Product> productList2 = productRepository.search("%C%");
		productList2.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("***************4************");
		List<Product> productList3 = productRepository.findByPriceGreaterThan(3000);
		productList3.forEach(p->{
			System.out.println(p.toString());
		});

		System.out.println("**************5*************");
		List<Product> productList4 = productRepository.searchByPrice(3000.00);
		productList4.forEach(p->{
			System.out.println(p.toString());
		});
	}
}
