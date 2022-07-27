package cvut.fel.dto;

import cvut.fel.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    AccountDTO accountToDto(Account account);
    CustomerDTO customerToDto (Customer customer);

}
