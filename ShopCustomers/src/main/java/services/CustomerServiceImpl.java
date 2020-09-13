package services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.CustomerInResponseDTO;

import model.CustomerDTO;
import repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public CustomerInResponseDTO getAllCustomer() {
		CustomerInResponseDTO customerInResponseDTO = null;
		Collection<CustomerDTO> customers = null;
		try {
			customers = (Collection<CustomerDTO>) this.repository.findAll();
			customerInResponseDTO = new CustomerInResponseDTO(customers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerInResponseDTO;
	}

	@Override
	public CustomerDTO getCustomerById(Integer id) {
		Optional<CustomerDTO> customer = null;
		try {
			customer = this.repository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer.get();
	}

	@Override
	public CustomerDTO addCustomer(CustomerDTO customer) {
		CustomerDTO customerCreate = null;
		try {
			customerCreate = this.repository.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerCreate;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customer) {
		Optional<CustomerDTO> customerUpdate = null;
		try {
			customerUpdate = this.repository.findById(customer.getId());
			customerUpdate.get().setLastName(customer.getLastName());
			customerUpdate.get().setName(customer.getName());
			customerUpdate.get().setStatus(customer.getStatus());
			customerUpdate.get().setEmail(customer.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.repository.save(customerUpdate.get());
	}

	@Override
	public CustomerDTO updateStatus(String status, Integer id) {
		Optional<CustomerDTO> customerUpdate = null;
		try {
			customerUpdate = this.repository.findById(id);
			customerUpdate.get().setStatus(status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.repository.save(customerUpdate.get());
	}

	@Override
	public Boolean delateCustomer(Integer id) {
		boolean delete = false;
		Optional<CustomerDTO> customerDelete = this.repository.findById(id);
		if (customerDelete.isPresent()) {
			this.repository.delete(customerDelete.get());
			delete = true;
		}
		return delete;
	}
}
