package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.AuthorDTO;
import com.dangers.libreria.entities.AuthorEntity;
import com.dangers.libreria.entities.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {

    @Mappings({
            @Mapping(source = "id_author", target = "id_author"),
            @Mapping(source = "nameAuthor", target = "nameAuthor"),
            @Mapping(source = "birthdate", target = "birthdate"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "nationality", target = "nationality"),
            @Mapping(source = "books", target = "books")
    })
    AuthorDTO authorToDTO(AuthorEntity author);

    @Mapping(target = "bookEntity", source = "books")
    List<AuthorDTO> toDTOList(List<AuthorEntity> authorEntityList);

    default BookEntity map(List<BookEntity> books) {
        // Aquí implementa la lógica para convertir la lista de libros en un único libro
        // Por ejemplo, puedes devolver el primer libro de la lista, o combinar los datos de varios libros, dependiendo de tus requisitos.
        // Este es solo un ejemplo simple:
        return books != null && !books.isEmpty() ? books.get(0) : null;
    }
}
