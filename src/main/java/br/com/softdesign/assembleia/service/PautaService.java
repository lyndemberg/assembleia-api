package br.com.softdesign.assembleia.service;

import br.com.softdesign.assembleia.dto.PautaDto;
import br.com.softdesign.assembleia.entity.PautaEntity;
import br.com.softdesign.assembleia.mapper.PautaMapper;
import br.com.softdesign.assembleia.repository.PautaRepository;
import br.com.softdesign.assembleia.exception.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class PautaService {

    private final PautaRepository pautaRepository;
    private final PautaMapper pautaMapper;

    public PautaService(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
        this.pautaMapper = Mappers.getMapper(PautaMapper.class);
    }

    public PautaDto cadastrar(PautaDto pautaDto) {
        PautaEntity pautaEntity = pautaMapper.dtoToEntity(pautaDto);
        pautaEntity.setInternalId(UUID.randomUUID().toString());
        return pautaMapper.entityToDto(pautaRepository.save(pautaEntity));
    }

    public PautaDto atualizar(String internalId, PautaDto pautaDto) {
        PautaEntity pautaEntity = pautaRepository.findByInternalId(internalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Pauta não encontrada para o identificador %s", internalId)));

        pautaMapper.updateEntity(pautaDto, pautaEntity);

        return pautaMapper.entityToDto(pautaRepository.save(pautaEntity));
    }

    public void excluir(String internalId) {
        Optional<PautaEntity> pautaEntity = pautaRepository.findByInternalId(internalId);
        pautaEntity.ifPresent(entity -> pautaRepository.deleteById(entity.getId()));
    }

    public PautaDto recuperar(String internalId) {
        PautaEntity pautaEntity = pautaRepository.findByInternalId(internalId)
            .orElseThrow(() -> new EntityNotFoundException(String.format("Pauta não encontrada para o identificador %s", internalId)));

        return pautaMapper.entityToDto(pautaEntity);
    }

}
