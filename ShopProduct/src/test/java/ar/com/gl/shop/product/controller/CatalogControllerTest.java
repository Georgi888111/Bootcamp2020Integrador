package ar.com.gl.shop.product.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import ar.com.gl.shop.product.entity.Category;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.services.CategoryService;

@ExtendWith(MockitoExtension.class)
class CatalogControllerTest {

	@Mock
	private CategoryService categoryService;
	@InjectMocks
	private CatalogController catalogController;

	@BeforeEach
	public void setup() {
		catalogController = new CatalogController(categoryService);
	}

	@Test
	void retrieveCategoriesTest() throws SQLException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 23L, false);
		Category category2 = new Category("Catalog Test 2", "Test 2", 24L, false);
		List<Category> categorias = new ArrayList<Category>();
		categorias.add(category1);
		categorias.add(category2);
		Mockito.when(this.categoryService.readAllCategory()).thenReturn(categorias);
		List<Category> response = catalogController.retrieveCategories();
		assertEquals(categorias, response);
	}

	@Test
	void retrieveCategoryByIdTest() throws ApiException, SQLException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 30L, false);
		Mockito.when(this.categoryService.readCategory(category1.getId())).thenReturn(category1);
		Category response = catalogController.retrieveCategoryById(category1.getId());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getName(), response.getName());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getDescripcion(), response.getDescripcion());
		assertEquals(category1.isActivoCategory(), response.isActivoCategory());
	}

	@Test
	void retrieveCategoryByNameTest() throws ApiException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 47L, false);
		Mockito.when(this.categoryService.readCategoryByName(category1.getName())).thenReturn(category1);
		Category response = catalogController.retrieveCategoryByName(category1.getName());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getName(), response.getName());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getDescripcion(), response.getDescripcion());
		assertEquals(category1.isActivoCategory(), response.isActivoCategory());
	}

	@Test
	void createCategoryTest() throws SQLException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 55L, false);
		Mockito.when(this.categoryService.createCategory(category1)).thenReturn(category1);
		Category response = catalogController.createCategory(category1);
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getName(), response.getName());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getDescripcion(), response.getDescripcion());
		assertEquals(category1.isActivoCategory(), response.isActivoCategory());
	}

	@Test
	void updateCategoryDescription() throws ApiException, SQLException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 43L, false);
		Mockito.when(this.categoryService.updateCategoryDescription(category1.getId(), category1))
				.thenReturn(category1);
		Category response = catalogController.updateCategoryDescription(category1.getId(), category1);
		assertEquals(category1.getDescripcion(), response.getDescripcion());
	}

	@Test
	void disableCategoryTest() throws ApiException, SQLException {
		Category category1 = new Category("Catalog Test 1", "Test 1", 33L, false);
		Mockito.when(this.categoryService.deleteCategory(category1.getId())).thenReturn(category1);
		Category response = catalogController.disableCategory(category1.getId());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getName(), response.getName());
		assertEquals(category1.getId(), response.getId());
		assertEquals(category1.getDescripcion(), response.getDescripcion());
		assertEquals(category1.isActivoCategory(), response.isActivoCategory());
	}
}