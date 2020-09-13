package ar.com.gl.shop.product.exceptions;

public class ApiException extends Exception{
	private String message;
	
	public ApiException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
