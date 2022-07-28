package cvut.fel.dto;

import cvut.fel.entity.Account;

import java.time.Year;

public class AccountCustomerDTO extends AbstractDTO {
    public long amount;
    public Year creation;
    public int phonenumber;

    public Account account;

    public AccountCustomerDTO(long amount, Year creation, int phonenumber, Account account) {
        this.amount = amount;
        this.creation = creation;
        this.phonenumber = phonenumber;
        this.account = account;
    }

    public AccountCustomerDTO(AccountCustomerDTO dto) {
        super(dto);
        amount = dto.amount;
        creation = dto.creation;
        phonenumber = dto.phonenumber;
        account = dto.account;
    }
    @Override
    protected AbstractDTO clone() {
        return new AccountCustomerDTO(this);
    }
}
