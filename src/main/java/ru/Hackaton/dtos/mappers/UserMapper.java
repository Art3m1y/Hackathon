package ru.Hackaton.dtoes.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.Hackaton.dtoes.UserDto;
import ru.Hackaton.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(UserDto userDto);
}
