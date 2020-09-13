package ar.com.gl.shop.product.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.com.gl.shop.product.entity.Category;
import ar.com.gl.shop.product.entity.Product;
import ar.com.gl.shop.product.entity.Stock;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.repository.ProductRepository;
import ar.com.gl.shop.product.services.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	ProductRepository repository;
	@InjectMocks
	ProductServiceImpl productService;

	@BeforeEach

	public void setUp() {
		productService = new ProductServiceImpl(repository);

	}

	@Test
	void createProductTest() {
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
		when(this.repository.save(product)).thenReturn(product);
		Product response = productService.createProduct(product);
		assertEquals(product.getId(), response.getId());

	}

	@Test
	void readProductTest() {
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
		when(this.repository.findById(product.getId())).thenReturn(Optional.of(product));		
		Product response = productService.readProduct(product.getId());
		assertEquals(product.getId(), response.getId());
	}

	@Test
	void updateProductTest() {
		
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
		when(this.repository.findById(product.getId())).thenReturn(Optional.of(product));
		when(this.repository.save(product)).thenReturn(product);
		Product response = productService.updateProduct(product);
		assertEquals(product.getId(), response.getId());
	
		
	}

	@Test
	void deleteProductTest() {
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
		when(this.repository.findById(product.getId())).thenReturn(Optional.of(product));
		Product response = productService.deleteProduct(product.getId());
		assertNotNull(response);
	}


	@Test
	void readProductsTest() {
		List<Product> products = new ArrayList<Product>();
		Stock stock = new Stock(1L, 200, "Estanteria 1");
		Category category = new Category("Golosinas", "Alfajor", 1L, true);
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
		Stock stock2 = new Stock(2L, 356, "Estanteria 2");
		Category category2 = new Category("Golosinas", "Chupetines", 2L, true);
		Product product2 = new Product(2L, "Chupetin Pop's", "Chupetin sabores variados", 15.5, 1L, 1L);

		products.add(product);
		products.add(product2);

		when(this.repository.findAll()).thenReturn(products);
		List<Product> response = new ArrayList<Product>();
		response = productService.readProducts();
		assertEquals(products, response);
	}

	@Test
	void readProductbyNameOrCategoryIdTest() throws ApiException {
		Product product = new Product(1L, "Alfajor jorgito", "Alfajor de chocolate", 70.5, 1L, 1L);
	
		when(this.repository.findByNameOrCategoryId(product.getName(), product.getCategory()))
				.thenReturn(Optional.of(product));
		Product response = productService.readProductbyNameOrCategoryId(product.getName(),
				product.getCategory());
		assertEquals(product.getId(), response.getId());
		

	}
}
