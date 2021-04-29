package br.com.zupacademy.romeu.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String nome;

  @Email @NotBlank
  @Column(unique = true, nullable = false)
  private String email;

  @NotBlank @Size(max = 400)
  @Column(nullable = false)
  private String descricao;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDateTime criadoEm;

  @Deprecated
  /**
   * deve ser usado somente pelo hibernate
   */
  public Autor(){};

  public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getDescricao() {
    return descricao;
  }

  public LocalDateTime getCriadoEm() {
    return criadoEm;
  }
}
