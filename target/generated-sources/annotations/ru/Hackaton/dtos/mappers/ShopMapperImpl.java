package ru.Hackaton.dtos.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.Hackaton.dtos.ShopDto;
import ru.Hackaton.models.Shop;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T17:49:10+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class ShopMapperImpl implements ShopMapper {

    @Override
    public ShopDto mapToShopDto(Shop shop) {
        if ( shop == null ) {
            return null;
        }

        ShopDto shopDto = new ShopDto();

        shopDto.setId( shop.getId() );
        shopDto.setName( shop.getName() );

        return shopDto;
    }

    @Override
    public Shop mapToShop(ShopDto shopDto) {
        if ( shopDto == null ) {
            return null;
        }

        Shop shop = new Shop();

        shop.setId( shopDto.getId() );
        shop.setName( shopDto.getName() );

        return shop;
    }

    @Override
    public List<ShopDto> mapToShopDtoList(List<Shop> shopList) {
        if ( shopList == null ) {
            return null;
        }

        List<ShopDto> list = new ArrayList<ShopDto>( shopList.size() );
        for ( Shop shop : shopList ) {
            list.add( mapToShopDto( shop ) );
        }

        return list;
    }

    @Override
    public List<Shop> mapToShopList(List<ShopDto> shopDtoList) {
        if ( shopDtoList == null ) {
            return null;
        }

        List<Shop> list = new ArrayList<Shop>( shopDtoList.size() );
        for ( ShopDto shopDto : shopDtoList ) {
            list.add( mapToShop( shopDto ) );
        }

        return list;
    }
}
