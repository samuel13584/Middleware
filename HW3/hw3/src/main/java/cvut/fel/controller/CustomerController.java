package cvut.fel.controller;

import cvut.fel.dto.CustomerDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerController {

    private final CustomerService customerService;
    private final DTOMapper dtoMapper;

    @Autowired
    public CustomerController(CustomerService customerService, DTOMapper dtoMapper) {
        this.customerService = customerService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.customerToDto(customerService.findById(id)));
    }

}
