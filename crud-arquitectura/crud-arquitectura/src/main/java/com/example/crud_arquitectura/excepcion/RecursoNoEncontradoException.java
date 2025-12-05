package com.example.crud_arquitectura.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada que se lanza cuando se intenta acceder a un registro
 * que no existe en la base de datos
 * * La anotación @ResponseStatus convierte automáticamente esta excepción
 * en un código de respuesta HTTP 404 (NOT_FOUND)
 * @author Aldrin, Charly, Erick y Giuseph
 * @version 1.0
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

    /**
     * Constructor que recibe el mensaje de error detallado.
     * @param mensaje Descripción del error.
     */
    public RecursoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
