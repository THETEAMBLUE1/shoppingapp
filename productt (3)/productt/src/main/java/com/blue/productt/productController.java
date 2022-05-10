package com.blue.productt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RequestMapping("/product")

public class productController {
	@Autowired
	private productRepo product;

	@PostMapping("/addproduct")
	public product addProduct(@RequestBody product p) {
		return product.save(p);
	}

	@GetMapping("/deteils")
	public Iterable<product> getProducts() {
		return product.findAll();

	}

	@GetMapping("/detail/{productId}")
	public Optional<product> getProductDetails(@PathVariable Long productId) {
		return product.findById(productId);
	}

	@GetMapping("/remove/{productId}")
	public boolean removeProductDetail(@PathVariable Long productId) {
		Optional<product> p = this.getProductDetails(productId);
		if (p.isPresent()) {
			product.delete(p.get());
			return true;
		} else {
			return false;
		}
	}

}
