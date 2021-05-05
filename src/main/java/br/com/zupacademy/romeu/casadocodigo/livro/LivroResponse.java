package br.com.zupacademy.romeu.casadocodigo.livro;

public class  LivroResponse {

  private Long id;
  private String titulo;

  /**
   * para uso exclusivo do hibernate
   */
  @Deprecated
  public LivroResponse() {
  }

  public LivroResponse(Livro livro) {
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }
}
