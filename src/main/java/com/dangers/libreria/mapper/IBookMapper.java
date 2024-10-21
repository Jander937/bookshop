package com.dangers.libreria.mapper;

import com.dangers.libreria.entities.*;
import com.dangers.libreria.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookMapper {


    @Mappings({
            @Mapping(source = "id_book", target = "id_book"),
            @Mapping(source = "isbn", target = "isbn"),
            @Mapping(source = "publication_year", target = "publication_year"),
            @Mapping(source = "title", target = "title"),
            @Mapping(source = "bookCoverEntity", target = "bookCoverEntity"),
            @Mapping(source = "authors", target = "authors"),
            @Mapping(source = "loans", target = "loans"),
            @Mapping(source = "genders", target = "genders"),
            @Mapping(source = "editorialEntity", target = "editorialEntity"),
            @Mapping(source = "customers", target = "customers")
    })
    BookDTO bookToDTO(BookEntity book);

    List<BookDTO> toDTOList(List<BookEntity> bookEntityList);

    default GenderEntity mapGenders(GenderEntity gender) {
        // Implementa la lógica para convertir el género
        return gender;
    }
}
