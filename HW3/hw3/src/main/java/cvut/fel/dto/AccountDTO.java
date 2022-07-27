package cvut.fel.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@Getter
@Setter
public class AccountDTO extends AbstractDTO{

    public long amount;
    public Year creation;

    public AccountDTO() {
    }

    public AccountDTO(AccountDTO dto) {
        super(dto);
        amount = dto.getAmount();
        creation= dto.getCreation();
    }

    @Override
    public AbstractDTO clone() {
        return new AccountDTO(this);
    }

}
