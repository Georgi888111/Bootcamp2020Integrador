package in;

import java.util.Collection;

import model.CustomerDTO;

public class CustomerInResponseDTO {

	private Collection<CustomerDTO> customerDto;

	public CustomerInResponseDTO(Collection<CustomerDTO> customerDto) {
		super();
		this.customerDto = customerDto;
	}

	public Collection<CustomerDTO> getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(Collection<CustomerDTO> customerDto) {
		this.customerDto = customerDto;
	}

}
