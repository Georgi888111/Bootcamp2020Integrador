package ar.com.gl.shop.product.services;

import ar.com.gl.shop.product.entity.Stock;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ar.com.gl.shop.product.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService {

	StockRepository stockRepositoryImpl;

	public StockServiceImpl(StockRepository stockRepositoryImpl) {
		this.stockRepositoryImpl = stockRepositoryImpl;
	}

	@Override
	public void createStock(Stock stock) throws SQLException {
		this.stockRepositoryImpl.save(stock);
	}

	@Override
	public Stock readStock(Long id) throws Exception{
		Optional<Stock> stock = null;
		try {
			stock = this.stockRepositoryImpl.findById(id);
			if(stock==null) {
				throw new Exception("El stock es nulo");
			}
		} catch(SQLException e){
			e.printStackTrace();
		}
		return stock.get();
			
	}

	@Override
	public void updateStock(Stock stock) throws SQLException{
		this.stockRepositoryImpl.save(stock);
	}

	@Override
	public void deleteStock(Long id) throws SQLException {
		Stock entity = new Stock();
		entity.setId(id);
		this.stockRepositoryImpl.delete(entity); 
	}

}