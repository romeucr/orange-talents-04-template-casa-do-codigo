package br.com.zupacademy.romeu.casadocodigo.categoria;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerificaUnicidadeNoBanco;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

  @NotBlank
  @VerificaUnicidadeNoBanco(autorOuCategoria = "categoria")
  private String nome;

  public Categoria toModel() {
    return new Categoria(this.nome);
  }

  public String getNome() {
    return nome;
  }
}
