package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.UserDto;
import ru.Hackaton.models.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User mapToUser(UserDto userDto);
}
