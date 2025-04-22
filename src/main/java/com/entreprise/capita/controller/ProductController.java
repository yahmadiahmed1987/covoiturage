package com.entreprise.capita.controller;

import com.entreprise.capita.model.ProductDTO;
import com.entreprise.capita.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product API", description = "API pour gérer les produits")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "Lister les produits", description = "Retourne tous les produits.")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PutMapping(value = "/{id}" , name = "updateProduct")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {

        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/product/{id}")
    EntityModel<ProductDTO> one(@PathVariable Long id) {

        ProductDTO prodEntity = productService.getProductById(id);

        return EntityModel.of(prodEntity, //
                linkTo(methodOn(ProductController.class).one(id)).withSelfRel(),
                linkTo(methodOn(ProductController.class).getAllProducts()).withRel("products"));
    }
}

