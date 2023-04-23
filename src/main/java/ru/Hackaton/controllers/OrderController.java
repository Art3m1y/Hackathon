package ru.Hackaton.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.OrderDto;
import ru.Hackaton.dtos.mappers.OrderMapper;
import ru.Hackaton.services.OrderService;

import static ru.Hackaton.controllers.Validation.validateRequestBody;
import static ru.Hackaton.controllers.Validation.validateStringForLong;

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
    public ResponseEntity<?> create(@Valid @RequestBody OrderDto newOrderDto, BindingResult bindingResult) {
        validateRequestBody(bindingResult);

        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.save(
                orderMapper.mapToOrder(newOrderDto))));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@Valid @RequestBody OrderDto orderDto, BindingResult bindingResult) {
        validateRequestBody(bindingResult);

        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.upgrade(
                orderMapper.mapToOrder(orderDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        validateStringForLong(id);

        return ResponseEntity.ok(orderMapper.mapToOrderDto(orderService.findById(Long.parseLong(id))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        validateStringForLong(id);

        orderService.delete(Long.parseLong(id));

        return ResponseEntity.ok().build();
    }
}
