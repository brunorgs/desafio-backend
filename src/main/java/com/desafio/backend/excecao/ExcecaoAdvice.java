package com.desafio.backend.excecao;

import com.desafio.backend.dto.ErroValidacaoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
public class ExcecaoAdvice {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErroValidacaoDto trataExcecaoValidacao(MethodArgumentNotValidException excecao) {
        return new ErroValidacaoDto(mapErrors(excecao));
    }

    private List<String> mapErrors(MethodArgumentNotValidException exception) {

        List<String> mensagens = new ArrayList<>();

        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            mensagens.add(String.format("O campo %s %s",
                    error.getField(),
                    messageSource.getMessage(error, Locale.forLanguageTag("pt_BR"))));
        }

        return mensagens;
    }
}
