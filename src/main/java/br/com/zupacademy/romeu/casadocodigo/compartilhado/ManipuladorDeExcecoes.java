package br.com.zupacademy.romeu.casadocodigo.compartilhado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorDeExcecoes {

  @Autowired
  MessageSource messageSource;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErroRequest> handle(MethodArgumentNotValidException exception) {
    List<ErroRequest> dto = new ArrayList<>();
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(e -> {
      String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      ErroRequest erro = new ErroRequest(e.getField(), mensagem);
      dto.add(erro);
    });

    return dto;
  }

}
