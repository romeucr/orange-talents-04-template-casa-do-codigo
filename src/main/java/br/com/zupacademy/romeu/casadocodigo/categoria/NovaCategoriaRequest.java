package br.com.zupacademy.romeu.casadocodigo.categoria;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.ValorUnico;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

  @NotBlank
  @ValorUnico(campo = "nome", tabela = Categoria.class)
  private String nome;

  public Categoria toModel() {
    return new Categoria(this.nome);
  }

  public String getNome() {
    return nome;
  }
}
