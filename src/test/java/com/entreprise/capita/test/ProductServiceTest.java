package com.entreprise.capita.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entreprise.capita.entities.Product;
import com.entreprise.capita.model.ProductDTO;
import com.entreprise.capita.repository.ProductRepository;
import com.entreprise.capita.service.ProductService;
import com.entreprise.capita.tools.ProductMapper;



@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
    @Mock
    private ProductRepository productRepository;
    
    @InjectMocks
	private ProductService productService;
    
    @Mock
    private ProductMapper productMapper;
    
    private ProductDTO productDto ;
    private Optional<Product> prodOptional ;

    
    
    @BeforeEach
    public void setUp() {
    	
    	productDto = new ProductDTO();
    	productDto.setName("Whey BY CAPITA");
    	productDto.setPrice((double) 250);
    	
    	Product prod = new Product();
    	prod.setName("Whey BY CAPITA");
    	prod.setPrice((double) 250);
    
    	prodOptional = Optional.of(prod);
    }
    
    @Test
    public void getProductByIdTest() {
    	when(productRepository.findById((long) 1)).thenReturn(prodOptional);
    	when(productMapper.toDTO(prodOptional.get())).thenReturn(productDto);
    	
    	ProductDTO productById = productService.getProductById((long) 1);
    	
    	assertThat(productById.getName().equals(productDto.getName()));
    	assertThat(productById.getPrice()==productDto.getPrice());
    	
    }

}
