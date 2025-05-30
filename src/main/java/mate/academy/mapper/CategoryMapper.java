package mate.academy.mapper;

import mate.academy.config.MapperConfig;
import mate.academy.dao.category.CategoryDto;
import mate.academy.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface CategoryMapper {
    CategoryDto toDto(Category category);

    Category toEntity(CategoryDto categoryDto);

    void updateCategoryFromDto(CategoryDto categoryDto, @MappingTarget Category entity);
}
