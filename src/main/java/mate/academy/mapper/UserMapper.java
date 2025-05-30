package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.user.UserRegistrationRequestDto;
import mate.academy.dao.user.UserResponseDto;
import mate.academy.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto request);
}
