package ar.com.gl.shop.product.services;

import java.sql.SQLException;
import java.util.List;

import ar.com.gl.shop.product.entity.Category;
import ar.com.gl.shop.product.exceptions.ApiException;

public interface CategoryService {

	public Category createCategory(Category category) throws SQLException;

	public Category updateCategory(Category category) throws SQLException;

	public List<Category> readAllCategory() throws SQLException;

	public Category readCategory(Long id) throws SQLException;

	public Category deleteCategory(Long id) throws SQLException;

	public Category deleteLogicCategory(Long id) throws SQLException;

	public Category readCategoryByName(String name) throws ApiException;

	public Category updateCategoryDescription(Long id, Category category) throws ApiException;

}
