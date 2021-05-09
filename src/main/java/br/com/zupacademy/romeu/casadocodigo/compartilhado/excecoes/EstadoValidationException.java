package br.com.zupacademy.romeu.casadocodigo.compartilhado.excecoes;

public class EstadoValidationException extends RuntimeException {
  public EstadoValidationException(String msg) {
    super(msg);
  }
}
