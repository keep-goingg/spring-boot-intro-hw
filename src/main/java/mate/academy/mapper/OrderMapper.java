package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.model.Order;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class, uses = OrderItemMapper.class)
public interface OrderMapper {
    OrderResponseDto toDto(Order order);

    Order toEntity(OrderRequestDto orderRequestDto);
}
