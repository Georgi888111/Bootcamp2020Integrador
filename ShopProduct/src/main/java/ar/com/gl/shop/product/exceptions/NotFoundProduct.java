package ar.com.gl.shop.product.exceptions;

public class NotFoundProduct extends RuntimeException {

	private String code;
	private String message;

	public NotFoundProduct(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

}
