package br.com.softdesign.assembleia.mapper;

import br.com.softdesign.assembleia.dto.PautaDto;
import br.com.softdesign.assembleia.entity.PautaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface PautaMapper {

    PautaEntity dtoToEntity(PautaDto pautaDto);

    PautaDto entityToDto(PautaEntity pautaDto);

    @Mapping(target = "internalId", ignore = true)
    void updateEntity(PautaDto pautaAtualizada, @MappingTarget PautaEntity pautaEntity);

}
