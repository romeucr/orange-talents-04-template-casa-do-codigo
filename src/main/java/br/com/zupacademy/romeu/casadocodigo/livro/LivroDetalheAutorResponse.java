package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;

public class LivroDetalheAutorResponse {

  private String nome;
  private String descricao;

  public LivroDetalheAutorResponse(Autor autor) {
    this.nome = autor.getNome();
    this.descricao = autor.getDescricao();
  }

  public String getNome() {
    return nome;
  }

  public String getDescricao() {
    return descricao;
  }
}
