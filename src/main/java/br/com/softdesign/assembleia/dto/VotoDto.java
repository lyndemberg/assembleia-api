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
public class VotoDto implements Serializable {

    @NotBlank
    @NotNull
    private String sessaoId;

    @NotBlank
    @NotNull
    private String cpf;

    @NotNull
    private Boolean valor;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dataRegistro;
}
