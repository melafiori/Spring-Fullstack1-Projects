package com.duoc.TechStore.controllers;

import com.duoc.TechStore.exceptions.ProductException;
import com.duoc.TechStore.models.Product;
import com.duoc.TechStore.services.ProductService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET ALL
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductException("Producto no encontrado con ID: " + id);
        }
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) {
        updatedProduct.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.update(updatedProduct)); //productService.update(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productService.delete(id));
    }
}

