package br.com.zupacademy.romeu.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorInsertRequest {

  @NotBlank(message = "O campo nome é obrigatório")
  private String nome;

  @Email
  @NotBlank(message = "O campo email é obrigatório")
  private String email;

  @Size(max = 400)
  @NotBlank(message = "O campo descrição é obrigatório")
  private String descricao;

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getDescricao() {
    return descricao;
  }

  public Autor transformarEmModel() {
    return new Autor(this.nome, this.email, this.descricao);
  }

}

