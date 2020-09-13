package ar.com.gl.shop.product.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.com.gl.shop.product.entity.Product;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.services.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

	@Mock
	private ProductService service;
	@InjectMocks
	private ProductController productController;

	@BeforeEach
	public void setup() {
		productController = new ProductController(service);
	}

	@Test
	void retrieveProductsTest() {
		Product product1 = new Product(23L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Product product2 = new Product(24L, "Test 2", "Product Test", 100.00, 1L, 1L);
		ArrayList<Product> productos = new ArrayList<Product>();
		productos.add(product1);
		productos.add(product2);
		Mockito.when(this.service.readProducts()).thenReturn(productos);
		List<Product> response = productController.retrieveProducts();
		assertEquals(productos, response);
	}

	@Test
	void retrieveProductByIdTest() throws ApiException {
		Product product1 = new Product(35L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.readProduct(product1.getId())).thenReturn(product1);
		Product response = productController.retrieveProductById(product1.getId());
		assertEquals(product1.getId(), response.getId());
		assertEquals(product1.getName(), response.getName());
		assertEquals(product1.getDescription(), response.getDescription());
		assertEquals(product1.getPrice(), response.getPrice());
		assertEquals(product1.getStock(), response.getStock());
		assertEquals(product1.getCategory(), response.getCategory());
		assertEquals(product1.isActivoProducto(), response.isActivoProducto());
	}

	@Test
	void retrieveProductByNameOrCategoryTest() throws ApiException {
		Product product1 = new Product(46L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.readProductbyNameOrCategoryId(product1.getName(), product1.getCategory()))
				.thenReturn(product1);
		Product response = productController.retrieveProductByNameOrCategory(product1.getName(),
				product1.getCategory());
		assertEquals(product1.getId(), response.getId());
		assertEquals(product1.getName(), response.getName());
		assertEquals(product1.getDescription(), response.getDescription());
		assertEquals(product1.getPrice(), response.getPrice());
		assertEquals(product1.getStock(), response.getStock());
		assertEquals(product1.getCategory(), response.getCategory());
		assertEquals(product1.isActivoProducto(), response.isActivoProducto());
	}

	@Test
	void createProductTest() {
		Product product1 = new Product(50L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.createProduct(product1)).thenReturn(product1);
		Product response = productController.createProduct(product1);
		assertEquals(product1.getId(), response.getId());
		assertEquals(product1.getName(), response.getName());
		assertEquals(product1.getDescription(), response.getDescription());
		assertEquals(product1.getPrice(), response.getPrice());
		assertEquals(product1.getStock(), response.getStock());
		assertEquals(product1.getCategory(), response.getCategory());
		assertEquals(product1.isActivoProducto(), response.isActivoProducto());
	}

	@Test
	void updateProductTest() throws ApiException {
		Product product1 = new Product(65L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.updateProduct(product1)).thenReturn(product1);
		Product response = productController.updateProduct(product1);
		assertEquals(product1.getId(), response.getId());
		assertEquals(product1.getName(), response.getName());
		assertEquals(product1.getDescription(), response.getDescription());
		assertEquals(product1.getPrice(), response.getPrice());
		assertEquals(product1.getStock(), response.getStock());
		assertEquals(product1.getCategory(), response.getCategory());
		assertEquals(product1.isActivoProducto(), response.isActivoProducto());
	}

	@Test
	void updateProductAttributesTest() throws ApiException {
		Product product1 = new Product(70L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.updateProduct(product1)).thenReturn(product1);
		Product response = productController.updateProductAttributes(product1.getId(), product1);
		assertEquals(product1.getDescription(), response.getDescription());
	}

	@Test
	void deleteProductTest() throws ApiException {
		Product product1 = new Product(54L, "Test 1", "Product Test", 99.00, 1L, 1L);
		Mockito.when(this.service.deleteProduct(product1.getId())).thenReturn(product1);
		Product response = productController.deleteProduct(product1.getId());
		assertEquals(product1.getId(), response.getId());
		assertEquals(product1.getName(), response.getName());
		assertEquals(product1.getDescription(), response.getDescription());
		assertEquals(product1.getPrice(), response.getPrice());
		assertEquals(product1.getStock(), response.getStock());
		assertEquals(product1.getCategory(), response.getCategory());
		assertEquals(product1.isActivoProducto(), response.isActivoProducto());
	}
}
