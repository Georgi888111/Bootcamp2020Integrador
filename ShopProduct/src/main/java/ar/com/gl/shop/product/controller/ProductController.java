package ar.com.gl.shop.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.gl.shop.product.entity.Product;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.services.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Product microservice", description = "This API has a CRUD for product")
public class ProductController {

	private ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		super();
		this.service = service;
	}

	@GetMapping(path = "/product")
	@ApiOperation(value = "Find all products", notes = "Return all products")
	public List<Product> retrieveProducts() {
		return service.readProducts();

	}

	@GetMapping(path = "/product/{id}")
	@ApiOperation(value = "Find an product", notes = "Return a product by id")
	public Product retrieveProductById(@PathVariable(name = "id") final Long id) throws ApiException {
		return service.readProduct(id);
	}

	@GetMapping(path = "/product/search")
	@ApiOperation(value = "Find an product", notes = "Return a product by id or name")
	public Product retrieveProductByNameOrCategory(@RequestParam(name = "name") final String name,
			@RequestParam(name = "categoryId") final long categoryId) throws ApiException {
		return service.readProductbyNameOrCategoryId(name, categoryId);

	}

	@PostMapping(path = "/product")
	@ApiOperation(value = "Create an product", notes = "Create a new product")
	public Product createProduct(@RequestBody final Product product) {
		return service.createProduct(product);

	}

	@PutMapping(path = "/product")
	@ApiOperation(value = "Update an product", notes = "Update an product by Id")
	public Product updateProduct(@RequestBody final Product product) throws ApiException {
		return service.updateProduct(product);
	}

	@PatchMapping(path = "/product/{id}")
	@ApiOperation(value = "Update an product", notes = "Update an product by Id")
	public Product updateProductAttributes(@PathVariable(name = "id") final Long id, @RequestBody final Product product)
			throws ApiException {
		return service.updateProduct(product);

	}

	@DeleteMapping(path = "/product/{id}")
	@ApiOperation(value = "Delete an product", notes = "Delete a product by Id")
	public Product deleteProduct(@PathVariable(name = "id") final Long id) throws ApiException {
		return service.deleteProduct(id);

	}
}