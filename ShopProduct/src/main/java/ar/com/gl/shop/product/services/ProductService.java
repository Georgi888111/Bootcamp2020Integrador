package ar.com.gl.shop.product.services;

import java.util.List;

import ar.com.gl.shop.product.entity.Product;
import ar.com.gl.shop.product.exceptions.ApiException;

public interface ProductService {
	
	public Product createProduct(Product producto);
	
	public Product readProduct(Long id);
	
	public Product updateProduct(Product producto);
	
	public Product deleteProduct(Long id);
	
	public List<Product> readProducts();
	
	public Product readProductbyNameOrCategoryId(String name, Long categoryId) throws ApiException;
	
}
