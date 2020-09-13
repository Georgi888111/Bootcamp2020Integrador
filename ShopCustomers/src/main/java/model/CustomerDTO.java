package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class CustomerDTO {

	@Id
	@Column(name = "CU_ID")
	private int id;
	@Column(name = "CU_LASTNAME")
	private String lastName;
	@Column(name = "CU_FIRSTNAME")
	private String name;
	@Column(name = "CU_STATUS")
	private String status;
	@Column(name = "CU_EMAIL")
	private String email;

	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(int id, String lastName, String name, String status, String email) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.name = name;
		this.status = status;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
