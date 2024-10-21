package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.EditorialDTO;
import com.dangers.libreria.entities.BookEntity;
import com.dangers.libreria.entities.EditorialEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEditorialMapper {

    @Mappings({
            @Mapping(source = "id_editorial", target = "id_editorial"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "country", target = "country"),
            @Mapping(source = "website", target = "website"),
            @Mapping(source = "foundationYear", target = "foundationYear"),
            // Aquí se proporciona un método de mapeo personalizado para convertir la lista de libros a una sola entidad de libro
            @Mapping(target = "books", expression = "java(mapBooks(editorial.getBooks()))")
    })
    EditorialDTO editorialToDTO(EditorialEntity editorial);

    // Método para mapear una lista de entidades de Editorial a una lista de DTO de Editorial
    List<EditorialDTO> toDTOList(List<EditorialEntity> editorialEntityList);

    // Método de mapeo personalizado para convertir una lista de entidades de libros a una sola entidad de libro
    default List<BookEntity> mapBooks(List<BookEntity> books) {
        // Implementa aquí la lógica para convertir la lista de libros en una sola entidad de libro
        // Por ejemplo, puedes devolver el primer libro de la lista, o combinar los datos de varios libros según tus necesidades
        // Aquí hay un ejemplo simple:
        return (books != null && !books.isEmpty()) ? (List<BookEntity>) books.get(0) : null;
    }
}
