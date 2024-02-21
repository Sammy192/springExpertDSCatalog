package com.devsamuca.dscatalog.tests;

import com.devsamuca.dscatalog.dto.ProductDTO;
import com.devsamuca.dscatalog.entities.Category;
import com.devsamuca.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public  static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "Https://img.com/img.png", Instant.parse("2020-10-20T03:00:00z"));
        product.getCategories().add(createCategory());
        return product;
    }
    
    public static ProductDTO createProductDTO() {
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }

    public static Category createCategory() {
        return new Category("Electronics", 2L);
    }
}
