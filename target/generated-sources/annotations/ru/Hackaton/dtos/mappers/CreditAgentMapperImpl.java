package ru.Hackaton.dtos.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.Hackaton.dtos.CreditAgentAuthDto;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.dtos.CreditAgentRegisterDto;
import ru.Hackaton.models.CreditAgent;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T17:49:10+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class CreditAgentMapperImpl implements CreditAgentMapper {

    @Override
    public CreditAgentDto mapToCreditAgentDto(CreditAgent creditAgent) {
        if ( creditAgent == null ) {
            return null;
        }

        CreditAgentDto creditAgentDto = new CreditAgentDto();

        creditAgentDto.setUsername( creditAgent.getUsername() );
        creditAgentDto.setName( creditAgent.getName() );

        return creditAgentDto;
    }

    @Override
    public CreditAgent mapToCreditAgent(CreditAgentDto creditAgentDto) {
        if ( creditAgentDto == null ) {
            return null;
        }

        CreditAgent creditAgent = new CreditAgent();

        creditAgent.setUsername( creditAgentDto.getUsername() );
        creditAgent.setName( creditAgentDto.getName() );

        return creditAgent;
    }

    @Override
    public CreditAgent mapToCreditAgent(CreditAgentAuthDto creditAgentAuthDto) {
        if ( creditAgentAuthDto == null ) {
            return null;
        }

        CreditAgent creditAgent = new CreditAgent();

        creditAgent.setUsername( creditAgentAuthDto.getUsername() );
        creditAgent.setPassword( creditAgentAuthDto.getPassword() );

        return creditAgent;
    }

    @Override
    public CreditAgent mapToCreditAgent(CreditAgentRegisterDto creditAgentRegisterDto) {
        if ( creditAgentRegisterDto == null ) {
            return null;
        }

        CreditAgent creditAgent = new CreditAgent();

        creditAgent.setUsername( creditAgentRegisterDto.getUsername() );
        creditAgent.setPassword( creditAgentRegisterDto.getPassword() );
        creditAgent.setName( creditAgentRegisterDto.getName() );
        creditAgent.setSurname( creditAgentRegisterDto.getSurname() );
        creditAgent.setPatronymic( creditAgentRegisterDto.getPatronymic() );

        return creditAgent;
    }

    @Override
    public List<CreditAgentDto> mapToCreditAgentDtoList(List<CreditAgent> creditAgentList) {
        if ( creditAgentList == null ) {
            return null;
        }

        List<CreditAgentDto> list = new ArrayList<CreditAgentDto>( creditAgentList.size() );
        for ( CreditAgent creditAgent : creditAgentList ) {
            list.add( mapToCreditAgentDto( creditAgent ) );
        }

        return list;
    }

    @Override
    public List<CreditAgent> mapToCreditAgentList(List<CreditAgentDto> creditAgentDtoList) {
        if ( creditAgentDtoList == null ) {
            return null;
        }

        List<CreditAgent> list = new ArrayList<CreditAgent>( creditAgentDtoList.size() );
        for ( CreditAgentDto creditAgentDto : creditAgentDtoList ) {
            list.add( mapToCreditAgent( creditAgentDto ) );
        }

        return list;
    }
}
