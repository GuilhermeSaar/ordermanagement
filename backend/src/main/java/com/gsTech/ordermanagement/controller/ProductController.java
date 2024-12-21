package com.gsTech.ordermanagement.controller;

import com.gsTech.ordermanagement.dto.ProductDTO;
import com.gsTech.ordermanagement.entities.Product;
import com.gsTech.ordermanagement.services.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {

        ProductDTO dto = productService.getProductById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> findAllProducts(Pageable pageable) {

       Page<Product> result = productService.findAllProducts(pageable);
       Page<ProductDTO> resultDTO = result.map(ProductDTO::new);

       return ResponseEntity.ok().body(resultDTO);
    }

    @PostMapping
    public ResponseEntity<ProductDTO>  createProduct(@Valid @RequestBody ProductDTO productDTO) {

        ProductDTO dto = productService.createProduct(productDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(location).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {

        ProductDTO dto = productService.updateProduct(id, productDTO);
        return ResponseEntity.ok().body(dto);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        logger.info("Attempting to delete product with ID {}", id);
        productService.deleteProduct(id);
        logger.info("Successfully deleted product with ID {}", id);
        return ResponseEntity.noContent().build();
    }


















}
