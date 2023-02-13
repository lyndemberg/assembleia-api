package br.com.softdesign.assembleia.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor
public class VotoId implements Serializable {
    private String cpf;
    private String sessaoId;
}
