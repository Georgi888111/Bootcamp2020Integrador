package ar.com.gl.shop.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import in.CustomerInResponseDTO;
import model.CustomerDTO;
import services.CustomerService;

@RestController
public class CustomerController {
	//variable type CustomerService
	private CustomerService service;
	
	//constructor with autowired
	@Autowired
	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(path = "/customers")
	public ResponseEntity<CustomerInResponseDTO> getAllCustomer() {

		return new ResponseEntity<>(service.getAllCustomer(), HttpStatus.OK);
	}

	@GetMapping(path = "/customers/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(Integer id) {

		return new ResponseEntity<>(service.getCustomerById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/customers")
	public ResponseEntity<CustomerDTO> addCustomer(CustomerDTO customer) {

		return new ResponseEntity<>(service.addCustomer(customer), HttpStatus.OK);
	}

	@PutMapping(path = "/customers")
	public ResponseEntity<CustomerDTO> updateCustomer(CustomerDTO customer) {
		HttpStatus HttpStatus = null;
		return new ResponseEntity<>(service.updateCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping(path = "/customers/{id}")
	public ResponseEntity<Void> delateCustomer(Integer id) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PatchMapping(path = "/customers/{id}")
	public ResponseEntity<CustomerDTO> updateStatus(Integer id, String status) {

		return new ResponseEntity<>(service.updateStatus(status, id),HttpStatus.OK);
	}
}
