package mate.academy.repository;

import mate.academy.dao.order.OrderResponseDto;
import mate.academy.dao.order.OrderUpdateDto;
import mate.academy.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAllByUserId(Long userId, Pageable pageable);

    OrderResponseDto updateStatus(Long orderId, OrderUpdateDto updateDto);
}
