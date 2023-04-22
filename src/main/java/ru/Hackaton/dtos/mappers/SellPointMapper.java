package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.SellPointDto;
import ru.Hackaton.models.SellPoint;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SellPointMapper {
    SellPointDto mapToSellPointDto(SellPoint point);
    SellPoint mapToSellPoint(SellPointDto dto);

    List<SellPointDto> mapToSellPointDtoList(List<SellPoint> list);
    List<SellPoint> mapToSellPointList(List<SellPointDto> dtoList);
}
