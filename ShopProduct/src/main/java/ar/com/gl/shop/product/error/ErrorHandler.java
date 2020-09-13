package ar.com.gl.shop.product.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ar.com.gl.shop.product.exceptions.ApiException;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(value = {ApiException.class})
	public ResponseEntity<String> handleProductNotFoundException(Exception e){
		ApiException apiException = new ApiException(e.getMessage());
		return new ResponseEntity<>(apiException.getMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<String> handleGeneralException(Exception e){
		ApiException apiException = new ApiException("Vuelva a probar más tarde");
		return new ResponseEntity<>(apiException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
