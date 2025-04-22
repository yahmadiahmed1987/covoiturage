package com.entreprise.capita.tools;

import com.entreprise.capita.model.ProductDTO;
import org.springframework.stereotype.Component;
import com.entreprise.capita.entities.Product;

@Component
public class ProductMapper {

    // Convert Entity to DTO
    public ProductDTO toDTO(Product product) {

        if (product == null) {
            return null;
        }
        return new ProductDTO(product.getName(), product.getPrice());
    }

    // Convert DTO to Entity
    public Product toEntity(ProductDTO productDTO) {
        if (productDTO == null) {
            return null;
        }
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}

