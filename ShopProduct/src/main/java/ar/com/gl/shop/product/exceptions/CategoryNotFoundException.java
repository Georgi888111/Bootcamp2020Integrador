package ar.com.gl.shop.product.exceptions;

public class CategoryNotFoundException extends ApiException{
	
	public CategoryNotFoundException(String message) {
		super(message);
	}
	
}
