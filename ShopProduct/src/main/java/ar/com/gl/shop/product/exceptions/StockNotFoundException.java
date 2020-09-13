package ar.com.gl.shop.product.exceptions;

public class StockNotFoundException extends ApiException{
	
	public StockNotFoundException(String message) {
		super(message);
	}
	
}
