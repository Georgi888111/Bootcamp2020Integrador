package ar.com.gl.shop.product.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.gl.shop.product.entity.Category;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.exceptions.CategoryNotFoundException;
import ar.com.gl.shop.product.exceptions.NotFoundProduct;
import ar.com.gl.shop.product.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	CategoryRepository repository;

	@Autowired
	public CategoryServiceImpl(CategoryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Category createCategory(Category category) {
		Category categoryCreate = null;
		try {
			categoryCreate = this.repository.save(category);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryCreate;
	}

	@Override
	public Category readCategory(Long id) {
		Optional<Category> categoryRead = null;

		try {
			categoryRead = this.repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return categoryRead.get();

	}

	@Override
	public Category updateCategory(Category category) {
		Optional<Category> categoryUpdate = null;
		try {
			categoryUpdate = this.repository.findById(category.getId());
			categoryUpdate.get().setName(category.getName());
			categoryUpdate.get().setDescripcion(category.getDescripcion());
			categoryUpdate.get().setActivoCategory(category.isActivoCategory());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.repository.save(categoryUpdate.get());

	}

	@Override
	public Category deleteCategory(Long id) {
		Category categoryDelete = null;
		try {
			categoryDelete = this.readCategory(id);
			if (categoryDelete == null) {
				throw new NotFoundProduct("Codigo-1", " No se pudo encontrar la categoría buscada");
			} else if (categoryDelete.isActivoCategory() == true) {
				throw new NotFoundProduct("Codigo-2", " No se pudo borrar la categoría");
			} else {
				this.repository.deleteById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryDelete;
	}

	@Override
	public Category deleteLogicCategory(Long id) {
		Optional<Category> category = null;
		try {
			category = this.repository.findById(id);
			if (category.get().isActivoCategory() == true) {
				category.get().setActivoCategory(false);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return this.repository.save(category.get());

	}

	@Override
	public List<Category> readAllCategory() {
		ArrayList<Category> category = new ArrayList<Category>();
		try {
			category = (ArrayList<Category>) this.repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return category;
	}

	@Override
	public Category readCategoryByName(String name) throws ApiException {

		Optional<Category> category = null;
		try {
			category = repository.findByName(name);
		} catch (Exception e) {
			throw new CategoryNotFoundException("No se ha podido encontrar la categoría buscada");
		}

		return category.get();
	}

	@Override
	public Category updateCategoryDescription(Long id, Category category) throws ApiException {
		Optional<Category> categoryUpdate = null;
		try {
			categoryUpdate = repository.findById(category.getId());
			categoryUpdate.get().setDescripcion(category.getDescripcion());

		} catch (Exception e) {
			throw new CategoryNotFoundException("No se ha podido encontrar la categoría buscada");
		}

		return this.repository.save(categoryUpdate.get());

	}

}