package br.com.zupacademy.romeu.casadocodigo.pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "tb_pais")
public class Pais {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  public Pais(){}

  public Pais(@NotBlank String nome) {
    this.nome = nome;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pais pais = (Pais) o;
    return nome.equals(pais.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome);
  }
}
