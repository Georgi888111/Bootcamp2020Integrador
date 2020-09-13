package ar.com.gl.shop.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.gl.shop.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public Optional<Product> findByNameOrCategoryId(final String name, final Long categoryId);
}
