package cvut.fel;

import cvut.fel.dto.AccountCustomerDTO;
import cvut.fel.dto.AccountDTO;
import cvut.fel.dto.CustomerDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.facade.AccountCustomer;
import cvut.fel.service.AccountService;
import cvut.fel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AccountController {

    private final AccountService accountService;
    private final CustomerService customerService;
    private final DTOMapper dtoMapper;

    private final AccountCustomer accountCustomer;

    @Autowired
    public AccountController(AccountService accountService, DTOMapper dtoMapper, CustomerService customerService, AccountCustomer accountCustomer) {
        this.accountService = accountService;
        this.dtoMapper = dtoMapper;
        this.customerService = customerService;
        this.accountCustomer = accountCustomer;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
       return ResponseEntity.ok(dtoMapper.accountToDto(accountService.findById(id)));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.customerToDto(customerService.findById(id)));
    }

    @GetMapping("/aggregate/account-customer")
    public ResponseEntity<AccountCustomerDTO> getAccountCustomer(@RequestParam Long accountId, @RequestParam Long customerId) {
        return ResponseEntity.ok(accountCustomer.accountCustomer(accountId, customerId));
    }
}