package com.gsTech.ordermanagement.services;

import com.gsTech.ordermanagement.dto.ProductDTO;
import com.gsTech.ordermanagement.entities.Product;
import com.gsTech.ordermanagement.repositories.ProductRepository;
import com.gsTech.ordermanagement.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    // busca por id
    @Transactional(readOnly = true)
    public ProductDTO getProductById(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new ProductDTO(product);
    }

    // todos produtos
    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllProducts(Pageable pageable) {

        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::new);
    }
    
}
