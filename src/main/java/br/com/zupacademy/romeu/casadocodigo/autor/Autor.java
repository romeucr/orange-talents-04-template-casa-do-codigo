package br.com.zupacademy.romeu.casadocodigo.autor;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_autor")
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String email;
  private String descricao;

  @CreationTimestamp
  private LocalDateTime criadoEm;

  public Autor(String nome, String email, String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

}
