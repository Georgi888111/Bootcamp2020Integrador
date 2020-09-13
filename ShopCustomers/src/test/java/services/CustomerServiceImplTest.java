package services;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import in.CustomerInResponseDTO;
import model.CustomerDTO;
import repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

	@Mock
	CustomerRepository repository;
	@InjectMocks
	CustomerServiceImpl customerService;
	
	@BeforeEach
	public void setUp() {
		customerService = new CustomerServiceImpl(repository);
	}
	
	@Test
	void getAllCustomerTest() {
		List<CustomerDTO> value = new ArrayList<CustomerDTO>();
		CustomerDTO customer = new CustomerDTO(51, "Get", "AllCustomer", "Test 1", "ignacio@gmail.com");
		CustomerDTO customer2 = new CustomerDTO(52, "GetAll", "Customer", "Test 2", "ignacio@gmail.com");
		value.add(customer);
		value.add(customer2);
		Iterable<CustomerDTO> customers = value;
		Mockito.when(this.repository.findAll()).thenReturn(customers);
		CustomerInResponseDTO response = customerService.getAllCustomer();
		assertEquals(customers, response.getCustomerDto());
	}
	
	@Test
	void getCustomerByIdTest() {
		CustomerDTO customer = new CustomerDTO(11, "Get", "CustomerById", "Test", "ignacio@gmail.com");
		Mockito.when(this.repository.findById(customer.getId())).thenReturn(Optional.of(customer));
		CustomerDTO response = customerService.getCustomerById(customer.getId());
		assertEquals(customer.getId(), response.getId());
		assertEquals(customer.getLastName(), response.getLastName());
		assertEquals(customer.getName(), response.getName());
		assertEquals(customer.getStatus(), response.getStatus());
		assertEquals(customer.getEmail(), response.getEmail());
	}
	
	@Test
	void addCustomerTest() {
		CustomerDTO customer = new CustomerDTO(21, "Add", "Customer", "Test", "ignacio@gmail.com");
		Mockito.when(this.repository.save(customer)).thenReturn(customer);
		CustomerDTO response = customerService.addCustomer(customer);
		assertEquals(customer.getId(), response.getId());
		assertEquals(customer.getLastName(), response.getLastName());
		assertEquals(customer.getName(), response.getName());
		assertEquals(customer.getStatus(), response.getStatus());
		assertEquals(customer.getEmail(), response.getEmail());
	}
	
	@Test
	void updateCustomerTest() {
		CustomerDTO customer = new CustomerDTO(31, "Update", "Customer", "Test", "ignacio@gmail.com");
		Mockito.when(this.repository.findById(customer.getId())).thenReturn(Optional.of(customer));
		Mockito.when(this.repository.save(customer)).thenReturn(customer);
		CustomerDTO response = customerService.updateCustomer(customer);
		assertEquals(customer.getId(), response.getId());
		assertEquals(customer.getLastName(), response.getLastName());
		assertEquals(customer.getName(), response.getName());
		assertEquals(customer.getStatus(), response.getStatus());
		assertEquals(customer.getEmail(), response.getEmail());
	}
	
	@Test
	void updateStatusTest() {
		CustomerDTO customer = new CustomerDTO(41, "Update", "CustomerStatus", "Test", "ignacio@gmail.com");
		Mockito.when(this.repository.findById(customer.getId())).thenReturn(Optional.of(customer));
		Mockito.when(this.repository.save(customer)).thenReturn(customer);
		CustomerDTO response = customerService.updateStatus(customer.getStatus(), customer.getId());
		assertEquals(customer.getStatus(), response.getStatus());
	}
	
	@Test
	void delateCustomerTest() {
		CustomerDTO customer = new CustomerDTO(33, "Delate", "Customer", "Test", "ignacio@gmail.com");
		Mockito.when(this.repository.findById(customer.getId())).thenReturn(Optional.of(customer));
		boolean response = customerService.delateCustomer(customer.getId());
		assertTrue(response);
	}
}
