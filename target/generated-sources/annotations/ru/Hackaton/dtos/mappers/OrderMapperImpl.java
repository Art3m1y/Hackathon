package ru.Hackaton.dtos.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.Hackaton.dtos.OrderDto;
import ru.Hackaton.models.Order;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-23T17:49:10+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto mapToOrderDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setPaymentMethod( order.getPaymentMethod() );
        orderDto.setPhoneNumber( order.getPhoneNumber() );
        orderDto.setCategory( order.getCategory() );
        orderDto.setPrice( order.getPrice() );

        return orderDto;
    }

    @Override
    public Order mapToOrder(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( orderDto.getId() );
        order.setPaymentMethod( orderDto.getPaymentMethod() );
        order.setPhoneNumber( orderDto.getPhoneNumber() );
        order.setCategory( orderDto.getCategory() );
        order.setPrice( orderDto.getPrice() );

        return order;
    }

    @Override
    public List<OrderDto> mapToOrderDtoList(List<Order> orderList) {
        if ( orderList == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orderList.size() );
        for ( Order order : orderList ) {
            list.add( mapToOrderDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> mapToOrderList(List<OrderDto> orderDtoList) {
        if ( orderDtoList == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( orderDtoList.size() );
        for ( OrderDto orderDto : orderDtoList ) {
            list.add( mapToOrder( orderDto ) );
        }

        return list;
    }
}
