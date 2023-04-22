package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.models.CreditAgent;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditAgentMapper {
    CreditAgentDto mapToCreditAgentDto(CreditAgent agent);
    CreditAgent mapToCreditAgent(CreditAgentDto dto);

    List<CreditAgentDto> mapToCreditAgentDtoList(List<CreditAgent> list);
    List<CreditAgent> mapToCreditAgentList(List<CreditAgentDto> dtoList);
}
