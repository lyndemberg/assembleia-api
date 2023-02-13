package br.com.softdesign.assembleia.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
public class ApuracaoSessaoResponseDto implements Serializable {

    private SessaoDto sessaoDto;
    private PautaDto pautaDto;
    private Integer votoSim;
    private Integer votoNao;

}
