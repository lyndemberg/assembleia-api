package br.com.softdesign.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SessaoDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String internalId;

    @NotBlank
    @NotNull
    private String pautaId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long tempoSegundos;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime horaInicio;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime horaEncerramento;


}
