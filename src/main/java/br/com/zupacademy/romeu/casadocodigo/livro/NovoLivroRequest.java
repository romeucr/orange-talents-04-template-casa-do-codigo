package br.com.zupacademy.romeu.casadocodigo.livro;

import br.com.zupacademy.romeu.casadocodigo.autor.Autor;
import br.com.zupacademy.romeu.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.Categoria;
import br.com.zupacademy.romeu.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.romeu.casadocodigo.categoria.NovaCategoriaRequest;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.ValorUnico;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerifyIfExists;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class NovoLivroRequest {

  @NotBlank
  @ValorUnico(campo = "titulo", tabela = Livro.class)
  private String titulo;

  @NotBlank @Length(max = 500)
  private String resumo;

  private String sumario;

  @NotNull @Min(20) @Positive
  private BigDecimal preco;

  @NotNull @Min(100) @Positive
  private Integer numeroDePaginas;

  @NotBlank @ISBN @ValorUnico(campo = "isbn", tabela = Livro.class)
  private String isbn;

  @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
  private LocalDate dataDePublicacao;

  @NotNull @VerifyIfExists(campo = "id", tabela = Categoria.class)
  private Long categoriaId;

  @NotNull @VerifyIfExists(campo = "id", tabela = Autor.class)
  private Long autorId;

  public NovoLivroRequest(){}

  public NovoLivroRequest(@NotBlank @ValorUnico(campo = "titulo", tabela = Livro.class) String titulo,
                          @NotBlank @Length(max = 500) String resumo,
                          @NotNull @Min(20) @Positive BigDecimal preco,
                          @NotNull @Min(100) @Positive Integer numeroDePaginas,
                          @NotBlank @ISBN @ValorUnico(campo = "isbn", tabela = Livro.class) String isbn,
                          @NotNull @Future @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) LocalDate dataDePublicacao,
                          @NotNull @VerifyIfExists(campo = "id", tabela = Categoria.class) Long categoriaId,
                          @NotNull @VerifyIfExists(campo = "id", tabela = Autor.class) Long autorId) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.preco = preco;
    this.numeroDePaginas = numeroDePaginas;
    this.isbn = formataIsbn(isbn);
    this.dataDePublicacao = dataDePublicacao;
    this.categoriaId = categoriaId;
    this.autorId = autorId;
  }

  public Livro toModel(CategoriaRepository categoriaRepository, AutorRepository autorRepository) {
    Optional<Categoria> optCategoria = categoriaRepository.findById(this.categoriaId);
    Categoria categoria = optCategoria.get();

    Optional<Autor> optAutor = autorRepository.findById(this.autorId);
    Autor autor = optAutor.get();

    return new Livro (this.titulo, this.resumo, this.sumario,
            this.preco, this.numeroDePaginas, formataIsbn(this.isbn),
            this.dataDePublicacao, categoria, autor);
  }

  public String formataIsbn(String isbn) {
    return isbn.replaceAll("[^0-9]", "");
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

  public Long getCategoriaId() {
    return categoriaId;
  }

  public Long getAutorId() {
    return autorId;
  }
}
