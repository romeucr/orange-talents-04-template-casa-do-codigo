package br.com.zupacademy.romeu.casadocodigo.estado;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.VerifyEstadoPais;
import br.com.zupacademy.romeu.casadocodigo.pais.Pais;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.executable.ValidateOnExecution;

@Entity
@Table(name = "tb_estado")
public class Estado {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String nome;

  @NotNull
  @ManyToOne
  private Pais pais;

  @Deprecated
  public Estado(){}

  public Estado(@NotBlank String nome, @NotNull Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Pais getPais() {
    return pais;
  }
}
