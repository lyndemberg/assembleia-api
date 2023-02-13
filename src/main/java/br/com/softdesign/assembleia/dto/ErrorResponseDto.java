package br.com.softdesign.assembleia.dto;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Builder
@ToString
public class ErrorResponseDto implements Serializable {

    private int status;
    private String errorMessage;
    private Instant timestamp;

}
