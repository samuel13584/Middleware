package cvut.fel.facade;

import cvut.fel.dto.AccountCustomerDTO;
import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;
import cvut.fel.service.AccountService;
import cvut.fel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class AccountCustomer {
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;

    public AccountCustomerDTO accountCustomer(Long accountId, Long customerId) {
        Account account = accountService.findById(accountId);
        Customer customer = customerService.findById(customerId);

        return new AccountCustomerDTO(account.getAmount(), account.getCreation(), customer.getPhonenumber(), customer.getAccount());
    }
}