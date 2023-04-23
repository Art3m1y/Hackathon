package ru.Hackaton.dtos.mappers;

import org.mapstruct.Mapper;
import ru.Hackaton.dtos.OrderDto;
import ru.Hackaton.models.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto mapToOrderDto(Order order);
    Order mapToOrder(OrderDto orderDto);

    List<OrderDto> mapToOrderDtoList(List<Order> orderList);
    List<Order> mapToOrderList(List<OrderDto> orderDtoList);
}
