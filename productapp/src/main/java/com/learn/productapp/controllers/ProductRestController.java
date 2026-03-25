package com.learn.productapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.learn.productapp.ProductappApplication;
import com.learn.productapp.dto.Voucher;
import com.learn.productapp.model.Product;
import com.learn.productapp.repo.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {

    private final ProductappApplication productappApplication;

	@Autowired
	private ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${voucherService.url}")
	private String voucherServiceURl;

    ProductRestController(ProductappApplication productappApplication) {
        this.productappApplication = productappApplication;
    }
	
	@PostMapping("/products/")
	public Product create(@RequestBody Product product) {
		Voucher voucher=restTemplate.getForObject(voucherServiceURl + product.getVoucherCode(),Voucher.class );
		product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
		
		return repo.save(product);
	}
	
}
