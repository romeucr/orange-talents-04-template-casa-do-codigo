package br.com.zupacademy.romeu.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

  @NotBlank
  private String nome;

  public Categoria toModel() {
    return new Categoria(this.nome);
  }

  public String getNome() {
    return nome;
  }
}
