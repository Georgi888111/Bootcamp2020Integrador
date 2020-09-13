package ar.com.gl.shop.product.services;

import ar.com.gl.shop.product.entity.Stock;
import java.sql.SQLException;


public interface StockService {
	
	public void createStock(Stock stock) throws SQLException;
	
	public Stock readStock(Long id) throws Exception;
	
	public void updateStock(Stock stock) throws SQLException;
	
	public void deleteStock(Long id) throws SQLException;

}
