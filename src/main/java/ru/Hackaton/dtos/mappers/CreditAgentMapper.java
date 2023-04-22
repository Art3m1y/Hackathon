package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.models.CreditAgent;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CreditAgentMapper {
    CreditAgentDto mapToCreditAgentDto(CreditAgent creditAgent);
    CreditAgent mapToCreditAgent(CreditAgentDto creditAgentDto);

    List<CreditAgentDto> mapToCreditAgentDtoList(List<CreditAgent> creditAgentList);
    List<CreditAgent> mapToCreditAgentList(List<CreditAgentDto> creditAgentDtoList);
}
