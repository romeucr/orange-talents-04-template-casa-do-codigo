package br.com.zupacademy.romeu.casadocodigo.autor;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.ValorUnico;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {

  @NotBlank
  private String nome;

  @Email @NotBlank @Column(unique = true)
  @ValorUnico(campo = "email", tabela = Autor.class)
  private String email;

  @NotBlank @Size(max = 400)
  private String descricao;

  public NovoAutorRequest(@NotBlank String nome,
                          @Email @NotBlank String email,
                          @NotBlank @Size(max = 400) String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
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

  public Autor toModel() {
    return new Autor(this.nome, this.email, this.descricao);
  }

}

