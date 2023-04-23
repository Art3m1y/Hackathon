package ru.Hackaton.dtos.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.dtos.SellPointDto;
import ru.Hackaton.dtos.ShopDto;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.SellPoint;
import ru.Hackaton.models.Shop;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T13:31:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class SellPointMapperImpl implements SellPointMapper {

    @Override
    public SellPointDto mapToSellPointDto(SellPoint sellPoint) {
        if ( sellPoint == null ) {
            return null;
        }

        SellPointDto sellPointDto = new SellPointDto();

        sellPointDto.setId( sellPoint.getId() );
        sellPointDto.setName( sellPoint.getName() );
        sellPointDto.setShop( shopToShopDto( sellPoint.getShop() ) );
        sellPointDto.setAgents( creditAgentListToCreditAgentDtoList( sellPoint.getAgents() ) );

        return sellPointDto;
    }

    @Override
    public SellPoint mapToSellPoint(SellPointDto sellPointDto) {
        if ( sellPointDto == null ) {
            return null;
        }

        SellPoint sellPoint = new SellPoint();

        sellPoint.setId( sellPointDto.getId() );
        sellPoint.setName( sellPointDto.getName() );
        sellPoint.setShop( shopDtoToShop( sellPointDto.getShop() ) );
        sellPoint.setAgents( creditAgentDtoListToCreditAgentList( sellPointDto.getAgents() ) );

        return sellPoint;
    }

    @Override
    public List<SellPointDto> mapToSellPointDtoList(List<SellPoint> sellPointList) {
        if ( sellPointList == null ) {
            return null;
        }

        List<SellPointDto> list = new ArrayList<SellPointDto>( sellPointList.size() );
        for ( SellPoint sellPoint : sellPointList ) {
            list.add( mapToSellPointDto( sellPoint ) );
        }

        return list;
    }

    @Override
    public List<SellPoint> mapToSellPointList(List<SellPointDto> sellPointDtoList) {
        if ( sellPointDtoList == null ) {
            return null;
        }

        List<SellPoint> list = new ArrayList<SellPoint>( sellPointDtoList.size() );
        for ( SellPointDto sellPointDto : sellPointDtoList ) {
            list.add( mapToSellPoint( sellPointDto ) );
        }

        return list;
    }

    protected ShopDto shopToShopDto(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDto shopDto = new ShopDto();

        shopDto.setId( shop.getId() );
        shopDto.setName( shop.getName() );

        return shopDto;
    }

    protected CreditAgentDto creditAgentToCreditAgentDto(CreditAgent creditAgent) {
        if ( creditAgent == null ) {
            return null;
        }

        CreditAgentDto creditAgentDto = new CreditAgentDto();

        creditAgentDto.setUsername( creditAgent.getUsername() );
        creditAgentDto.setName( creditAgent.getName() );

        return creditAgentDto;
    }

    protected List<CreditAgentDto> creditAgentListToCreditAgentDtoList(List<CreditAgent> list) {
        if ( list == null ) {
            return null;
        }

        List<CreditAgentDto> list1 = new ArrayList<CreditAgentDto>( list.size() );
        for ( CreditAgent creditAgent : list ) {
            list1.add( creditAgentToCreditAgentDto( creditAgent ) );
        }

        return list1;
    }

    protected Shop shopDtoToShop(ShopDto shopDto) {
        if ( shopDto == null ) {
            return null;
        }

        Shop shop = new Shop();

        shop.setId( shopDto.getId() );
        shop.setName( shopDto.getName() );

        return shop;
    }

    protected CreditAgent creditAgentDtoToCreditAgent(CreditAgentDto creditAgentDto) {
        if ( creditAgentDto == null ) {
            return null;
        }

        CreditAgent creditAgent = new CreditAgent();

        creditAgent.setUsername( creditAgentDto.getUsername() );
        creditAgent.setName( creditAgentDto.getName() );

        return creditAgent;
    }

    protected List<CreditAgent> creditAgentDtoListToCreditAgentList(List<CreditAgentDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CreditAgent> list1 = new ArrayList<CreditAgent>( list.size() );
        for ( CreditAgentDto creditAgentDto : list ) {
            list1.add( creditAgentDtoToCreditAgent( creditAgentDto ) );
        }

        return list1;
    }
}
