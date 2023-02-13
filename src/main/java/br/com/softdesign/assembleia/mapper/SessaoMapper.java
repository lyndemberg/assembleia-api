package br.com.softdesign.assembleia.mapper;

import br.com.softdesign.assembleia.dto.SessaoDto;
import br.com.softdesign.assembleia.entity.SessaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SessaoMapper {

    SessaoEntity dtoToEntity(SessaoDto sessaoDto);

    @Mapping(target = "pautaId", source = "pauta.internalId")
    SessaoDto entityToDto(SessaoEntity sessaoEntity);

}
