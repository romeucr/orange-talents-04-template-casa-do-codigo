package br.com.zupacademy.romeu.casadocodigo.categoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank @Column(unique = true, nullable = false)
  private String nome;

  @Deprecated
  public Categoria(){}

  public Categoria (@NotBlank String nome) {
    this.nome = nome;
  }

}