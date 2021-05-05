package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerifyIfExists;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheResponse {

  @NotBlank @VerifyIfExists(campo = "id", tabela = Livro.class)
  private Long id;

  @NotBlank
  private String titulo;

  @NotBlank @Length(max = 500) @Size(max = 500)
  private String resumo;

  @NotBlank
  private String sumario;

  @NotNull @Min(20) @Positive
  private BigDecimal preco;

  @NotNull @Min(100) @Positive
  private Integer numeroDePaginas;

  @NotBlank @ISBN
  private String isbn;

  @NotNull @Future
  private LocalDate dataDePublicacao;

  @NotNull @Valid
  private Categoria categoria;

  @NotNull @Valid
  private Autor autor;

  /**
   * para uso exclusivo do hibernate
   */
  @Deprecated
  public LivroDetalheResponse(){}

  public LivroDetalheResponse(@NotBlank Long id,
                              @NotBlank String titulo,
                              @NotBlank @Length(max = 500) String resumo,
                              @NotBlank String sumario,
                              @NotNull @Min(20) @Positive BigDecimal preco,
                              @NotNull @Min(100) @Positive Integer numeroDePaginas,
                              @NotBlank @ISBN String isbn,
                              @NotNull @Future LocalDate dataDePublicacao,
                              @NotNull @Valid Categoria categoria,
                              @NotNull @Valid Autor autor) {
    this.id = id;
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroDePaginas = numeroDePaginas;
    this.isbn = isbn;
    this.dataDePublicacao = dataDePublicacao;
    this.categoria = categoria;
    this.autor = autor;
  }

  public LivroDetalheResponse(Livro livro) {
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
    this.resumo = livro.getResumo();
    this.sumario = livro.getSumario();
    this.preco = livro.getPreco();
    this.numeroDePaginas = livro.getNumeroDePaginas();
    this.isbn = livro.getIsbn();
    this.dataDePublicacao = livro.getDataDePublicacao();
    this.categoria = livro.getCategoria();
    this.autor = livro.getAutor();
  }

  public Long getId() {
    return id;
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

  public LocalDate getDataDePublicacao() {
    return dataDePublicacao;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public Autor getAutor() {
    return autor;
  }
}
