package br.com.softdesign.assembleia.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "sessao")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class SessaoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "internal_id", nullable = false, updatable = false)
    private String internalId;

    @ManyToOne
    @JoinColumn(name = "pauta_id", nullable = false)
    private PautaEntity pauta;

    @Column(name = "inicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "encerramento", nullable = false)
    private LocalDateTime horaEncerramento;

}
