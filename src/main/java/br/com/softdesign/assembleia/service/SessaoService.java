package br.com.softdesign.assembleia.service;

import br.com.softdesign.assembleia.dto.ApuracaoSessaoResponseDto;
import br.com.softdesign.assembleia.dto.SessaoDto;
import br.com.softdesign.assembleia.entity.PautaEntity;
import br.com.softdesign.assembleia.entity.SessaoEntity;
import br.com.softdesign.assembleia.entity.VotoEntity;
import br.com.softdesign.assembleia.exception.EntityNotFoundException;
import br.com.softdesign.assembleia.mapper.PautaMapper;
import br.com.softdesign.assembleia.mapper.SessaoMapper;
import br.com.softdesign.assembleia.repository.PautaRepository;
import br.com.softdesign.assembleia.repository.SessaoRepository;
import br.com.softdesign.assembleia.repository.VotoRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class SessaoService {

    private final SessaoRepository sessaoRepository;
    private final PautaRepository pautaRepository;
    private final VotoRepository votoRepository;
    private final SessaoMapper sessaoMapper;
    private final PautaMapper pautaMapper;


    public SessaoService(SessaoRepository sessaoRepository, PautaRepository pautaRepository, VotoRepository votoRepository) {
        this.sessaoRepository = sessaoRepository;
        this.pautaRepository = pautaRepository;
        this.votoRepository = votoRepository;
        this.sessaoMapper = Mappers.getMapper(SessaoMapper.class);
        this.pautaMapper = Mappers.getMapper(PautaMapper.class);
    }

    public SessaoDto iniciar(SessaoDto sessaoDto){
        LocalDateTime now = LocalDateTime.now();
        sessaoDto.setHoraInicio(now);
        sessaoDto.setHoraEncerramento(now.plusSeconds(sessaoDto.getTempoSegundos()));

        String pautaId = sessaoDto.getPautaId();
        PautaEntity pautaEntity = pautaRepository
                .findByInternalId(pautaId).orElseThrow(() -> new EntityNotFoundException("Pauta informada não encontrada"));

        SessaoEntity sessaoEntity = sessaoMapper.dtoToEntity(sessaoDto);
        sessaoEntity.setPauta(pautaEntity);
        sessaoEntity.setInternalId(UUID.randomUUID().toString());

        return sessaoMapper.entityToDto(sessaoRepository.save(sessaoEntity));
    }

    public SessaoDto recuperar(String internalId){
        SessaoEntity sessaoEntity = sessaoRepository.findByInternalId(internalId)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Sessão não encontrada para o identificador %s", internalId)));

        return sessaoMapper.entityToDto(sessaoEntity);
    }

    public ApuracaoSessaoResponseDto apurarVotos(String sessaoInternalId){
        SessaoEntity sessao = sessaoRepository.findByInternalId(sessaoInternalId).orElseThrow(() -> new EntityNotFoundException("Sessão não encontrada"));
        PautaEntity pauta = sessao.getPauta();

        List<VotoEntity> votos = votoRepository.findById_SessaoId(sessaoInternalId);
        List<VotoEntity> votoSim = votos.stream().filter(v -> v.getValor()).toList();
        List<VotoEntity> votoNao = votos.stream().filter(v -> !v.getValor()).toList();

        return ApuracaoSessaoResponseDto.builder()
                .sessaoDto(sessaoMapper.entityToDto(sessao))
                .pautaDto(pautaMapper.entityToDto(pauta))
                .votoSim(votoSim.size())
                .votoNao(votoNao.size())
                .build();
    }
}
