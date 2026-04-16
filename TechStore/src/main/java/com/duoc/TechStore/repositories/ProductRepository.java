package com.duoc.TechStore.repositories;

import com.duoc.TechStore.exceptions.ProductException;
import com.duoc.TechStore.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList = new ArrayList<>();

    public List<Product> getAll() { return this.productList; }

    public Product findById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Product save(Product newProduct) {
        Product productFindId = findById(newProduct.getId());
        if (productFindId == null) {
            this.productList.add(newProduct);
            return newProduct;
        } else {
            throw new ProductException("Producto con id " + newProduct.getId() + " ya existe.");
        }
    }

    public Product update(Product updatedProduct) {
        int position = 0;
        boolean find = false;
        for (int i= 0; i<this.productList.size(); i++) {
            if (this.productList.get(i).getId().equals(updatedProduct.getId())) {
                position = i;
                find = true;
                break;
            }
        }

        if (find) {
            this.productList.set(position, updatedProduct);
            return updatedProduct;
        } else {
            throw new ProductException("Producto con id " + updatedProduct.getId() + " no existe.");
        }
    }

    public void delete(Long id) {
        Product product = this.findById(id);
        this.productList.remove(product);
    }


    public ProductRepository() {
        productList.add(new Product(1L,"EG-2000" ,"Laptop bacana", "Laptop de alta gama", 1500.00, 10));
        productList.add(new Product(2L, "VF-1234", "Smartphone bacano", "Smartphone con cámara de alta resolución", 800.00, 20));
        productList.add(new Product(3L,"AS-12938", "Tablet grande", "Tablet con pantalla de 10 pulgadas", 400.00, 15));

    }
}
