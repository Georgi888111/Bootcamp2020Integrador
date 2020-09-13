package ar.com.gl.shop.product.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gl.shop.product.entity.Category;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.services.CategoryService;

@RestController

public class CatalogController {

	private CategoryService service;

	@Autowired
	public CatalogController(CategoryService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/catalog")
	public List<Category> retrieveCategories() throws SQLException {
		return service.readAllCategory();
	}

	@GetMapping(path = "/catalog/{id}")
	public Category retrieveCategoryById(@PathVariable(name = "id") final Long id) throws ApiException, SQLException {
		return service.readCategory(id);
	}

	@GetMapping(path = "/catalog/search")
	public Category retrieveCategoryByName(@RequestParam(name = "name") final String name) throws ApiException {
		return service.readCategoryByName(name);
	}

	@PostMapping(path = "/catalog")
	public Category createCategory(@RequestBody final Category category) throws SQLException {
		return service.createCategory(category);
	}

	@PatchMapping(path = "/catalog/{id}")
	public Category updateCategoryDescription(@PathVariable(name = "id") final Long id,
			@RequestBody final Category category) throws ApiException {
		return service.updateCategoryDescription(id, category);
	}

	@DeleteMapping(path = "/catalog/{id}")
	public Category disableCategory(@PathVariable(name = "id") final Long id) throws ApiException, SQLException {
		return service.deleteCategory(id);
	}
}
