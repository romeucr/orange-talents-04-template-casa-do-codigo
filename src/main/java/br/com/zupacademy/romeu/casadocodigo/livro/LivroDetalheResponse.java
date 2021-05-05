package br.com.zupacademy.romeu.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class LivroDetalheResponse {

  private String titulo;
  private String resumo;
  private String sumario;
  private BigDecimal preco;
  private Integer numeroDePaginas;
  private String isbn;
  private String dataDePublicacao;
  private LivroDetalheAutorResponse autor;

  /**
   * para uso exclusivo do hibernate
   */
  @Deprecated
  public LivroDetalheResponse(){}

  public LivroDetalheResponse(String titulo, String resumo, String sumario, BigDecimal preco,
                              Integer numeroDePaginas, String isbn, String dataDePublicacao,
                              LivroDetalheAutorResponse autor) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroDePaginas = numeroDePaginas;
    this.isbn = isbn;
    this.dataDePublicacao = dataDePublicacao;
    this.autor = autor;
  }

  public LivroDetalheResponse(Livro livro) {
    this.titulo = livro.getTitulo();
    this.resumo = livro.getResumo();
    this.sumario = livro.getSumario();
    this.preco = livro.getPreco();
    this.numeroDePaginas = livro.getNumeroDePaginas();
    this.isbn = livro.getIsbn();
    this.dataDePublicacao = livro.getDataDePublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    this.autor = new LivroDetalheAutorResponse(livro.getAutor());
  }

  public String getTitulo() {
    return titulo;
  }

  public String getResumo() {
    return resumo;
  }

  public String getSumario() {
    return sumario;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public Integer getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getDataDePublicacao() {
    return dataDePublicacao;
  }

  public LivroDetalheAutorResponse getAutor() {
    return autor;
  }
}
