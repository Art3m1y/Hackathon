package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.SellPointDto;
import ru.Hackaton.models.SellPoint;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellPointMapper {
    SellPointDto mapToSellPointDto(SellPoint sellPoint);
    SellPoint mapToSellPoint(SellPointDto sellPointDto);

    List<SellPointDto> mapToSellPointDtoList(List<SellPoint> sellPointList);
    List<SellPoint> mapToSellPointList(List<SellPointDto> sellPointDtoList);
}
