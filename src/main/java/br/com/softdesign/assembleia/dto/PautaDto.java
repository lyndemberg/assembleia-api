package br.com.softdesign.assembleia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PautaDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String internalId;

    @NotBlank
    @NotNull
    private String titulo;

    @NotBlank
    @NotNull
    private String descricao;

}
