package br.com.softdesign.assembleia.exception;

public class VotoInvalidoException extends BadRequestException{

    public VotoInvalidoException(String message) {
        super(message);
    }

}
