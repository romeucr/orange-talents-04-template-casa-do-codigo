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

  @NotBlank(message = "O campo nome é obrigatório")
  private String nome;

  @Email
  @NotBlank(message = "O campo email é obrigatório")
  private String email;

  @Size(max = 400)
  @NotBlank(message = "O campo descrição é obrigatório")
  private String descricao;

  @CreationTimestamp
  private LocalDateTime criadoEm;


  public Autor(String nome, String email, String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

}
