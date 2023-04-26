package com.kgisl.AngularCrud;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    private List<Product> productList;

    @BeforeEach
    public void setUp() {
        productList = new ArrayList<>();
        productList.add(new Product(1L, "Product 1", "Description 1", 100.0));
        productList.add(new Product(2L, "Product 2", "Description 2", 200.0));
    }

    @Test
    public void testGetAllProducts() {
        when(productService.getAllProducts()).thenReturn(productList);
        List<Product> responseProducts = productController.getAllProducts();
        Assertions.assertEquals(productList.size(), responseProducts.size());
    }

    @Test
    public void testGetProductById() {
        Long id = 1L;
        Product product = new Product(id, "Product 1", "Description 1", 100.0);
        when(productService.getProductById(id)).thenReturn(product);
        Product responseProduct = productController.getProductById(id);
        Assertions.assertEquals(product.getId(), responseProduct.getId());
        Assertions.assertEquals(product.getName(), responseProduct.getName());
        Assertions.assertEquals(product.getDescription(), responseProduct.getDescription());
        Assertions.assertEquals(product.getPrice(), responseProduct.getPrice());
    }

    @Test
    public void testCreateProduct() {
        Product product = new Product(1L, "Product 1", "Description 1", 100.0);
        when(productService.createProduct(product)).thenReturn(product);
        Product responseProduct = productController.createProduct(product);
        Assertions.assertEquals(product.getId(), responseProduct.getId());
        Assertions.assertEquals(product.getName(), responseProduct.getName());
        Assertions.assertEquals(product.getDescription(), responseProduct.getDescription());
        Assertions.assertEquals(product.getPrice(), responseProduct.getPrice());
    }

    @Test
    public void testUpdateProduct() {
        Long id = 1L;
        Product updatedProduct = new Product(id, "Product 1 Updated", "Description 1 Updated", 200.0);
        when(productService.updateProduct(id, updatedProduct)).thenReturn(updatedProduct);
        Product responseProduct = productController.updateProduct(id, updatedProduct);
        Assertions.assertEquals(updatedProduct.getId(), responseProduct.getId());
        Assertions.assertEquals(updatedProduct.getName(), responseProduct.getName());
        Assertions.assertEquals(updatedProduct.getDescription(), responseProduct.getDescription());
        Assertions.assertEquals(updatedProduct.getPrice(), responseProduct.getPrice());
    }

    @Test
    public void testDeleteProduct() {
        Long id = 1L;
        ResponseEntity<?> responseEntity = productController.deleteProduct(id);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
