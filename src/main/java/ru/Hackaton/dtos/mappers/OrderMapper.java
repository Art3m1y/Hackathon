package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.OrderDto;
import ru.Hackaton.models.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto mapToOrderDto(Order order);
    Order mapToOrder(OrderDto dto);

    List<OrderDto> mapToOrderDtoList(List<Order> list);
    List<Order> mapToOrderList(List<OrderDto> dtoList);
}
