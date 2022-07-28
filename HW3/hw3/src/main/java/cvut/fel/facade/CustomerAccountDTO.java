package cvut.fel.facade;

import cvut.fel.dto.AccountDTO;
import cvut.fel.dto.CustomerDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Getter@Setter
public class CustomerAccountDTO {
    public AccountDTO accountDTO;
    public CustomerDTO customerDTO;

    public CustomerAccountDTO(CustomerAccountDTO dto){
        this.accountDTO = this.getAccountDTO();
        this.customerDTO = this.getCustomerDTO();
    }
    }
}
