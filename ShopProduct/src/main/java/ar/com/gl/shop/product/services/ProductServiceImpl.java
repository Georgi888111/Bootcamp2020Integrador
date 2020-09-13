package ar.com.gl.shop.product.services;

import ar.com.gl.shop.product.entity.Product;
import ar.com.gl.shop.product.exceptions.ApiException;
import ar.com.gl.shop.product.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.gl.shop.product.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepositoryImpl;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepositoryImpl) {
		super();
		this.productRepositoryImpl = productRepositoryImpl;
	}
	
	public Product createProduct(Product producto) {
		Product product=null;
		try {
			product = this.productRepositoryImpl.save(producto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	public Product readProduct(Long id) {

		Optional<Product> product = null;
		try {
			product = this.productRepositoryImpl.findById(id);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return product.get();

	}

	public Product updateProduct(Product producto) {
		Optional<Product> product = null;
		try {
			product= this.productRepositoryImpl.findById(producto.getId());
			product.get().setName(producto.getName());
			product.get().setDescription(producto.getDescription());
			product.get().setPrice(producto.getPrice());
			product.get().setStock(producto.getStock());
			product.get().setCategory(producto.getCategory());
			this.productRepositoryImpl.save(product.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product.get();
	}

	public Product deleteProduct(Long id) {
		Product product = null;
		try {
			product= this.readProduct(id);
			this.productRepositoryImpl.deleteById(id);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public List<Product> readProducts() {
		List<Product> product = new ArrayList<Product>();
		try {
			product = productRepositoryImpl.findAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product readProductbyNameOrCategoryId(String name, Long categoryId) throws ApiException {
		Optional<Product> productRead= null;
		try {
			productRead= productRepositoryImpl.findByNameOrCategoryId(name, categoryId);
			
		}catch (Exception e){
			throw new ProductNotFoundException("No se encontro el producto");
		}
		return productRead.get();
		
	}

}
