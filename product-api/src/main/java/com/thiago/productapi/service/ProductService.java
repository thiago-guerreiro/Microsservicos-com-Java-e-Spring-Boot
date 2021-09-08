package com.thiago.productapi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.productapi.converter.DTOConverter;
import com.thiago.productapi.model.Product;
import com.thiago.productapi.repository.CategoryRepository;
import com.thiago.productapi.repository.ProductRepository;
import com.thiago.shoppingclient.dto.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<ProductDTO> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}

	public List<ProductDTO> getProductByCategoryId(Long categoryId) {
		List<Product> products = productRepository.getProductByCategory(categoryId);
		return products.stream().map(DTOConverter::convert).collect(Collectors.toList());
	}

	public ProductDTO findByProductIdentifier(String productIdentifier) {
		Product product = productRepository.findByProductIdentifier(productIdentifier);
		if (product != null) {
			return DTOConverter.convert(product);
		}
		return null;
	}

	public ProductDTO save(ProductDTO productDTO) {
		Boolean existsCategory = categoryRepository.existsById(productDTO.getCategory().getId());
		if (!existsCategory) {
			return null;
		}
		Product product = productRepository.save(Product.convert(productDTO));
		return DTOConverter.convert(product);
	}

	public ProductDTO delete(long ProductId) {
		Optional<Product> Product = productRepository.findById(ProductId);
		if (Product.isPresent()) {
			productRepository.delete(Product.get());
		}
		return null;
	}

}
