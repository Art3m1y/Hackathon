package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.ShopDto;
import ru.Hackaton.models.Shop;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShopMapper {
    ShopDto mapToShopDto(Shop shop);
    Shop mapToShop(ShopDto dto);

    List<ShopDto> mapToShopDtoList(List<Shop> list);
    List<Shop> mapToShopList(List<ShopDto> dtoList);
}
