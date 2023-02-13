package br.com.softdesign.assembleia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "voto")
@Getter
@Setter
@ToString
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class VotoEntity implements Serializable {

    @EmbeddedId
    private VotoId id;

    @Column(name = "valor", nullable = false)
    private Boolean valor;

    @Column(name = "registrado", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dataRegistro;
}
