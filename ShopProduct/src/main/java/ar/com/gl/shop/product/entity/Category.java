package ar.com.gl.shop.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CATEGORY")
@ApiModel("Ctegory model")
public class Category {

	@Id
	@Column(name = "CA_ID")
	@ApiModelProperty(value = "id category", required = true)
	private Long id;

	@Column(name = "CA_DESCRIPTION")
	@ApiModelProperty(value = "description product", required = true)
	private String descripcion;

	@Column(name = "CA_NAME")
	@ApiModelProperty(value = "name product", required = true)
	private String name;

	@Column(name = "CA_ESTADO")
	@ApiModelProperty(value = "state product", required = true)
	private boolean activoCategory;

	public Category() {
		super();
	}

	public Category(String descripcion, String name, Long id, boolean activoCategory) {
		super();
		this.descripcion = descripcion;
		this.name = name;
		this.id = id;
		this.activoCategory = activoCategory;
	}

	public boolean isActivoCategory() {
		return activoCategory;
	}

	public void setActivoCategory(boolean activoCategory) {
		this.activoCategory = activoCategory;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
