package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_livro")
public class Livro {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
  private String titulo;

  @NotBlank @Length(max = 500) @Size(max = 500)
  @Column(columnDefinition = "VARCHAR(500)", nullable = false)
  private String resumo;

  @NotBlank
  @Column(nullable = false, unique = true, columnDefinition = "TEXT")
  private String sumario;

  @NotNull @Min(20) @Positive
  @Column(nullable = false)
  private BigDecimal preco;

  @NotNull @Min(100) @Positive
  @Column(nullable = false)
  private Integer numeroDePaginas;

  @NotBlank @ISBN
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(13)")
  private String isbn;

  @NotNull @Future
  @Column(nullable = false)
  private LocalDate dataDePublicacao;

  @ManyToOne @NotNull @Valid
  private Categoria categoria;

  @ManyToOne @NotNull @Valid
  private Autor autor;

  /**
   * para uso exclusivo do hibernate
   */
  @Deprecated
  public Livro(){}

  public Livro(@NotBlank String titulo,
               @NotBlank @Length(max = 500) String resumo,
               @NotBlank String sumario,
               @NotNull @Min(20) @Positive BigDecimal preco,
               @NotNull @Min(100) @Positive Integer numeroDePaginas,
               @NotBlank @ISBN String isbn,
               @NotNull @Future LocalDate dataDePublicacao,
               @NotNull @Valid Categoria categoria,
               @NotNull @Valid Autor autor) {
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
