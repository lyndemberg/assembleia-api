package br.com.softdesign.assembleia.service;

import br.com.softdesign.assembleia.dto.VotoDto;
import br.com.softdesign.assembleia.entity.VotoEntity;
import br.com.softdesign.assembleia.exception.EntityNotFoundException;
import br.com.softdesign.assembleia.exception.VotoInvalidoException;
import br.com.softdesign.assembleia.mapper.VotoMapper;
import br.com.softdesign.assembleia.repository.SessaoRepository;
import br.com.softdesign.assembleia.repository.VotoRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class VotoService {

    private final VotoRepository votoRepository;
    private final SessaoRepository sessaoRepository;
    private final VotoMapper votoMapper;

    public VotoService(VotoRepository votoRepository, SessaoRepository sessaoRepository) {
        this.votoRepository = votoRepository;
        this.sessaoRepository = sessaoRepository;
        this.votoMapper = Mappers.getMapper(VotoMapper.class);
    }


    public VotoDto registrar(VotoDto votoDto) {
        validaSessaoExistente(votoDto.getSessaoId());

        VotoEntity votoEntity = votoMapper.dtoToEntity(votoDto);

        if(votoRepository.findById(votoEntity.getId()).isPresent()){
            throw new VotoInvalidoException(String.format("CPF %s já votou na sessão %s", votoDto.getCpf(), votoDto.getSessaoId()));
        }

        votoEntity = votoRepository.save(votoEntity);
        log.info("Novo voto registrado {}", votoEntity);

        return votoMapper.entityToDto(votoEntity);
    }

    private void validaSessaoExistente(String sessaoInternalId){
        sessaoRepository.findByInternalId(sessaoInternalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Sessão não encontrada para o identificador %s", sessaoInternalId)));
    }

}
