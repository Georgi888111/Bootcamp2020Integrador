package ar.com.gl.shop.product.exceptions;

public class ProductNotFoundException extends ApiException{
	
	public ProductNotFoundException(String message) {
		super(message);
	}
	
}
