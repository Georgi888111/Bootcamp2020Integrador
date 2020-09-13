package ar.com.gl.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	@Column(name="ST_ID")
	private Long id;
	@Column(name="ST_QUANTITY")
	private Integer quantity;
	@Column(name="ST_LOCATION_CODE")
	private String locationCode;
	@Column(name="ST_ESTADO")
	private boolean activeStock;

	public Stock(Long id, Integer quantity, String locationCode) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.locationCode = locationCode;
	}

	public Stock() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}

	public boolean isActiveStock() {
		return activeStock;
	}

	public void setActiveStock(boolean activeStock) {
		this.activeStock = activeStock;
	}
}
