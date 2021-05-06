package br.com.zupacademy.romeu.casadocodigo.estado;

import br.com.zupacademy.romeu.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_estado")
public class Estado {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @NotNull @Valid
  @ManyToOne
  private Pais pais;

  @Deprecated
  public Estado(){}

  public Estado(@NotBlank String nome, @NotNull @Valid Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }

}
