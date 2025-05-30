package mate.academy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import mate.academy.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Orders management", description = "Endpoints for managing orders")
@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrderService orderService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Create a new order", description = "Create a new order")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDto createOrder(
            @PathVariable Long userId,
            @RequestBody @Valid OrderRequestDto requestDto) {
        return orderService.createOrder(userId, requestDto);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get all orders",
            description = "Get paginated and sorted list of all user's orders")
    @GetMapping
    public List<OrderResponseDto> getAllOrders(Long userId, Pageable pageable) {
        return orderService.getAllOrders(userId, pageable);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get all items by order id", description = "Get all items by order id")
    @GetMapping("/{orderId}/items")
    public List<OrderItemResponseDto> getItemsByOrderId(@PathVariable Long userId,
                                                        @PathVariable Long orderId) {
        return orderService.getItemsByOrderId(userId, orderId);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @Operation(summary = "Get specific item by order and item id",
            description = "Get specific item by order and item id")
    @GetMapping("/{orderId}/items/{itemId}")
    public OrderItemResponseDto getItemByOrderIdAndItemId(
            @PathVariable Long userId,
            @PathVariable Long orderId,
            @PathVariable Long itemId) {
        return orderService.getItemByOrderIdAndItemId(userId, orderId, itemId);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Update specific order status",
            description = "Update specific order status")
    @PutMapping("/{id}")
    public OrderResponseDto updateOrderStatus(
            @PathVariable Long id,
            @RequestBody @Valid OrderUpdateDto updateDto) {
        return orderService.updateOrderStatus(id, updateDto);
    }
}
