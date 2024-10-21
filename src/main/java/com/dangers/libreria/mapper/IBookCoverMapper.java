package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.BookCoverDTO;
import com.dangers.libreria.entities.BookCoverEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBookCoverMapper {

    @Mappings({
            @Mapping(source = "id_book_cover", target = "id_book_cover"),
            @Mapping(source = "coverImage", target = "urlImage"),
            @Mapping(source = "bookEntity", target = "bookEntity"),

    })
    BookCoverDTO bookCoverToDTO(BookCoverEntity bookCoverEntity);

    List<BookCoverDTO> toDTOList(List<BookCoverEntity> bookCoverEntityList);
}
