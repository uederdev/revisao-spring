package br.com.ueder.revisaospring.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException() {
    }

    public ObjectNotFoundException(String message) {
        super("Registro não encontrado: " + message);
    }
}
