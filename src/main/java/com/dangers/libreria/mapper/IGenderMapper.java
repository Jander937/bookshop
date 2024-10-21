package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.GenderDTO;
import com.dangers.libreria.entities.GenderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IGenderMapper {

    @Mappings({
            @Mapping(source = "id_gender", target = "id_gender"),
            @Mapping(source = "name", target = "name")
    })

    GenderDTO genderToDTO(GenderEntity gender);

    List<GenderDTO> toDTOLIst(List<GenderEntity> genderEntityList);
}
