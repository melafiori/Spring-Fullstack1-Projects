package com.duoc.TechStore.services;

import com.duoc.TechStore.models.Product;
import com.duoc.TechStore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository  productRepository;

    public List<Product> getAll() { return this.productRepository.getAll(); }

    public Product save(Product product) { return this.productRepository.save(product); }

    public Product update(Product updatedProduct) { return this.productRepository.update(updatedProduct); }

    public String delete(Long id) {
        this.productRepository.delete(id);
        return "Producto eliminado con exito";
    }

    public Product findById(Long id) { return this.productRepository.findById(id); }
}
