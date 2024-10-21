package com.dangers.libreria.mapper;

import com.dangers.libreria.dto.LoanDTO;
import com.dangers.libreria.entities.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ILoanMapper {

    @Mappings({
            @Mapping(source = "id_loan", target = "id_loan"),
            @Mapping(source = "loanDate", target = "loanDate"),
            // Mapea el estado del préstamo desde una clase relacionada (ejemplo: LoanStatusEntity)
            // Si el estado del préstamo está dentro de la entidad LoanEntity, asegúrate de usar el nombre correcto del campo.
            // Por ejemplo, si el estado del préstamo está dentro de LoanEntity y se llama "status", entonces:
            // @Mapping(source = "status", target = "status")
            // Si el estado del préstamo está en una clase relacionada, asegúrate de acceder a ella correctamente.
            // Por ejemplo, si el estado del préstamo está dentro de una clase relacionada llamada LoanStatusEntity y se llama "status", entonces:
            // @Mapping(source = "loanStatusEntity.status", target = "status")
            @Mapping(source = "return_date", target = "return_date"),
            @Mapping(source = "customerEntity", target = "customerEntity")
    })
    LoanDTO loanToDTO(LoanEntity loan);

    List<LoanDTO> toDTOlist(List<LoanEntity> loanEntityList);
}
