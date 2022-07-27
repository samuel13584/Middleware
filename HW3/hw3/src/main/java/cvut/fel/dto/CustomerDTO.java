package cvut.fel.dto;

import cvut.fel.entity.Account;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class CustomerDTO extends AbstractDTO{

    public int phonenumber;

    public Account account;

    public CustomerDTO() {
    }

    public CustomerDTO(CustomerDTO dto) {
        super(dto);
        phonenumber = dto.getPhonenumber();
        account= dto.getAccount();
    }

    @Override
    public AbstractDTO clone() {
        return new CustomerDTO(this);
    }

}
