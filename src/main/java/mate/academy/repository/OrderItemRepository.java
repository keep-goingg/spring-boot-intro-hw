package mate.academy.repository;

import java.util.List;
import java.util.Optional;
import mate.academy.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Optional<OrderItem> findByOrderIdAndItemId(Long orderId, Long itemId);

    List<OrderItem> findAllByOrderId(Long orderId);
}
