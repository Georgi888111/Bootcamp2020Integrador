package ar.com.gl.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PRODUCT")
@ApiModel("Product model")
public class Product {

	@Id
	@Column(name = "PR_ID")
	@ApiModelProperty(value = "id product", required = true)
	private Long id;

	@Column(name = "PR_NAME")
	@ApiModelProperty(value = "name product", required = true)
	private String name;

	@Column(name = "PR_DESCRIPTION")
	@ApiModelProperty(value = "description product", required = true)
	private String description;

	@Column(name = "PR_PRECIO")
	@ApiModelProperty(value = "price product", required = true)
	private Double price;

	@Column(name = "ST_ID")
	@ApiModelProperty(value = "stock product", required = true)
	private Long stock;

	@Column(name = "CA_ID")
	@ApiModelProperty(value = "category product", required = true)
	private Long categoryId;

	@Column(name = "PR_ESTADO")
	@ApiModelProperty(value = "state product", required = true)
	private boolean activoProducto;

	public Product() {
		super();

	}

	public Product(Long id, String name, String description, Double price, Long category, Long stock) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryId = category;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getCategory() {
		return categoryId;
	}

	public void setCategory(Long category) {
		this.categoryId = category;
	}

	public boolean isActivoProducto() {
		return activoProducto;
	}

	public void setActivoProducto(boolean activoProducto) {
		this.activoProducto = activoProducto;
	}

}
