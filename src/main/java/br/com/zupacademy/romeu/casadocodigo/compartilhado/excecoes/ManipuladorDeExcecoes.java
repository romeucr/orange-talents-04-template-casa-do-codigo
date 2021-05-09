package br.com.zupacademy.romeu.casadocodigo.compartilhado.excecoes;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.excecoes.ErroPadrao;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.excecoes.EstadoValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
  public List<ErroPadrao> handle(MethodArgumentNotValidException exception) {
    List<ErroPadrao> dto = new ArrayList<>();
    List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

    fieldErrors.forEach(e -> {
      String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      ErroPadrao erro = new ErroPadrao(e.getField(), mensagem);
      dto.add(erro);
    });

    return dto;
  }

  @ExceptionHandler(EstadoValidationException.class)
  public ResponseEntity<ErroPadrao> handle(EstadoValidationException exception) {
    ErroPadrao erro = new ErroPadrao("estadoId", exception.getMessage());
    return ResponseEntity.badRequest().body(erro);
  }

}
