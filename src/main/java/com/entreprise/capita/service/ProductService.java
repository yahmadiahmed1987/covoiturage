package com.entreprise.capita.service;

import com.entreprise.capita.entities.Product;
import com.entreprise.capita.model.ProductDTO;
import com.entreprise.capita.repository.ProductRepository;
import com.entreprise.capita.tools.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return productMapper.toDTO(product);
    }


    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        return productMapper.toDTO(productRepository.save(product));
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {

        Product productEntity = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produit non trouvé"));

        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        return productMapper.toDTO(productRepository.save(productEntity));
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}


