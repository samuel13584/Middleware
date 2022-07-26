package cvut.fel.dto;

import cvut.fel.entity.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOMapper {

    BookDTO bookToDto(Book book);

}
