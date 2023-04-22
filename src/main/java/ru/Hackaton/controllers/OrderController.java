package ru.Hackaton.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.OrderDto;
import ru.Hackaton.dtos.mappers.OrderMapper;
import ru.Hackaton.services.OrderService;

@RestController
@RequestMapping("/api/order")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class OrderController {

    OrderService orderService;
    OrderMapper orderMapper;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(orderMapper.mapToOrderDtoList(orderService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody OrderDto newOrderDto) {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.save(
                orderMapper.mapToOrder(newOrderDto))));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@RequestBody OrderDto orderDto) {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.upgrade(
                orderMapper.mapToOrder(orderDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.findById(id)));
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        orderService.delete(id);
    }
}
