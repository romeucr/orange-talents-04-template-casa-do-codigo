package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Entity
@Table(name = "tb_livro")
public class Livro {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;

  @NotBlank
  @Column(nullable = false, unique = true, columnDefinition = "VARCHAR(50)")
  private String titulo;

  @NotBlank @Length(max = 500)
  @Column(columnDefinition = "VARCHAR(500)", nullable = false)
  private String resumo;

  @Column(columnDefinition = "TEXT")
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

  @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = STRING)
  @Column(nullable = false)
  private LocalDate dataDePublicacao;

  @ManyToOne @NotNull
  private Categoria categoria;

  @ManyToOne @NotNull
  private Autor autor;

  public Livro(@NotBlank String titulo,
               @NotBlank @Length(max = 500) String resumo,
               String sumario,
               @NotNull @Min(20) @Positive BigDecimal preco,
               @NotNull @Min(100) @Positive Integer numeroDePaginas,
               @NotBlank @ISBN String isbn,
               @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = STRING) LocalDate dataDePublicacao,
               @NotNull Categoria categoria,
               @NotNull Autor autor) {
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

}
