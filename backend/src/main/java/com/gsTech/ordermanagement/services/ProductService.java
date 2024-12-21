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

import java.util.List;
import java.util.stream.Collectors;


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

    // listar todos produtos
    @Transactional(readOnly = true)
    public Page<Product> findAllProducts(Pageable pageable) {

       return productRepository.findAll(pageable);
    }


    // criar novo produto
    @Transactional
    public ProductDTO createProduct(ProductDTO productDTO) {

        Product product = new Product();
        copyProduct(productDTO, product);
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

       Product product = productRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Resource not found;"));

       copyProduct(productDTO, product);
       product = productRepository.save(product);
       return new ProductDTO(product);

    }

    @Transactional
    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found;"));

        productRepository.delete(product);

    }







    private void copyProduct(ProductDTO productDTO, Product product) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantityStock(productDTO.getQuantityStock());

    }






















}
