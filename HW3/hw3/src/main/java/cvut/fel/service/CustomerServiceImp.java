package cvut.fel.service;

import cvut.fel.entity.Customer;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id){

        if (id == null)
            throw new FieldMissingException();
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer_NOT_FOUND"));
    }

}
