package br.com.zupacademy.romeu.casadocodigo.pais;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.ValorUnico;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
}
