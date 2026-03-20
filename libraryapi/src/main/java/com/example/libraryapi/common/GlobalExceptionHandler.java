package com.example.libraryapi.common;

import com.example.libraryapi.controller.dto.ErroCampo;
import com.example.libraryapi.controller.dto.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        List<ErroCampo> listaDeErros = fieldErrors.stream().map(fe -> new ErroCampo(fe.getField(),
                fe.getDefaultMessage())).collect(Collectors.toList());

        return new ErroResposta(HttpStatus.UNPROCESSABLE_CONTENT.value(), "Erro de validação", listaDeErros);

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErroResposta handleHttpMessageNotReadable(HttpMessageNotReadableException e) {

        String mensagem = "JSON inválido";

        if (e.getCause() instanceof java.time.format.DateTimeParseException) {
            mensagem = "Formato de data inválido. Use yyyy-MM-dd";
        }

        return new ErroResposta(HttpStatus.BAD_REQUEST.value(), mensagem, List.of());
    }
}
