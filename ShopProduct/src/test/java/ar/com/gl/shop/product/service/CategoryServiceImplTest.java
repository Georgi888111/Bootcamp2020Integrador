package ar.com.gl.shop.product.service;

import static org.junit.Assert.assertEquals;
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
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.repository.CategoryRepository;
import ar.com.gl.shop.product.services.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

	@Mock
	CategoryRepository repository;
	@InjectMocks
	CategoryServiceImpl categoryService;

	@BeforeEach

	public void setUp() {
		categoryService = new CategoryServiceImpl(repository);

	}

	@Test
	void createCategoryTest() {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.save(category)).thenReturn(category);
		Category response = categoryService.createCategory(category);
		assertEquals(category.getId(), response.getId());
	}

	@Test
	void readCategoryTest() {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.findById(category.getId())).thenReturn(Optional.of(category));
		Category response = categoryService.readCategory(category.getId());
		assertEquals(category.getId(), response.getId());
	}

	@Test
	void updateCategoryTest() {

		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.findById(category.getId())).thenReturn(Optional.of(category));
		when(this.repository.save(category)).thenReturn(category);
		Category response = categoryService.updateCategory(category);
		assertEquals(category.getName(), response.getName());
		assertEquals(category.getDescripcion(), response.getDescripcion());

	}

	@Test
	void deleteCategoryTest() {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.findById(category.getId())).thenReturn(Optional.of(category));
		Category response = categoryService.deleteCategory(category.getId());
		assertEquals(category.getId(), response.getId());

	}

	@Test
	void deleteLogicCategoryTest() {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.findById(category.getId())).thenReturn(Optional.of(category));
		when(this.repository.save(category)).thenReturn(category);
		Category response = categoryService.deleteLogicCategory(category.getId());
		assertEquals(category.isActivoCategory(), response.isActivoCategory());
	}

	@Test
	void readAllCategoryTest() {
		List<Category> categories = new ArrayList<Category>();
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		Category category2 = new Category("Golosinas", "Alfajor", 1L, true);
		categories.add(category);
		categories.add(category2);

		when(this.repository.findAll()).thenReturn(categories);
		List<Category> response = new ArrayList<Category>();
		response = categoryService.readAllCategory();
		assertEquals(categories, response);

	}

	@Test
	void readCategoryByNameTest() throws ApiException {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
		when(this.repository.findByName(category.getName())).thenReturn(Optional.of(category));
		Category response = categoryService.readCategoryByName(category.getName());
		assertEquals(category.getId(), response.getId());

	}

	@Test
	void updateCategoryDescription() throws ApiException {
		Category category = new Category("Bebidas", "Bebida con gas", 3L, true);
	
		when(repository.findById(category.getId())).thenReturn(Optional.of(category));
		when(this.repository.save(category)).thenReturn(category);
		
		Category response = categoryService.updateCategoryDescription(category.getId(),category);
		assertEquals(category.getDescripcion(), response.getDescripcion());
	}

}