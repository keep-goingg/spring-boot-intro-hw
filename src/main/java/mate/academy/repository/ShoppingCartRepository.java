package mate.academy.repository;

import mate.academy.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findByUserId(Long userId);

    ShoppingCart getEntityByUserId(Long userId);
}
