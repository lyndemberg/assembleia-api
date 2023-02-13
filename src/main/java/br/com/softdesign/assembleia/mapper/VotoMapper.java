package br.com.softdesign.assembleia.mapper;

import br.com.softdesign.assembleia.dto.VotoDto;
import br.com.softdesign.assembleia.entity.VotoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VotoMapper {

    @Mapping(target = "dataRegistro", ignore = true)
    @Mapping(target = "id.cpf", source = "cpf")
    @Mapping(target = "id.sessaoId", source = "sessaoId")
    VotoEntity dtoToEntity(VotoDto votoDto);

    @Mapping(target = "cpf", source = "id.cpf")
    @Mapping(target = "sessaoId", source = "id.sessaoId")
    VotoDto entityToDto(VotoEntity votoEntity);

}
