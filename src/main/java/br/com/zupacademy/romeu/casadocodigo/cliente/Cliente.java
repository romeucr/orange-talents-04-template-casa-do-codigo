package br.com.zupacademy.romeu.casadocodigo.cliente;

import br.com.zupacademy.romeu.casadocodigo.estado.Estado;
import br.com.zupacademy.romeu.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank @Email
  @Column(unique = true, nullable = false)
  private String email;

  @NotBlank
  @Column(nullable = false)
  private String nome;

  @NotBlank
  @Column(nullable = false)
  private String sobrenome;

  @NotBlank //cpf ou cnpj - fazer validação composta
  @Column(unique = true, nullable = false)
  private String documento; //cpf ou CNPJ

  @NotBlank
  @Column(nullable = false)
  private String endereco;

  @NotBlank
  @Column(nullable = false)
  private String complemento;

  @NotBlank
  @Column(nullable = false)
  private String cidade;

  @NotBlank
  @Column(nullable = false)
  private String telefone;

  @NotBlank
  @Column(nullable = false)
  private String cep;

  @NotNull @Valid  // @Valid para validar os atributos de pais???
  @ManyToOne
  private Pais pais;

  @ManyToOne
  private Estado estado;

  /**
   * @deprecated usado pelo hibernate
   */

  public Cliente (){}

  public Cliente(@NotBlank @Email String email, @NotBlank String nome,
                 @NotBlank String sobrenome, @NotBlank String documento,
                 @NotBlank String endereco, @NotBlank String complemento,
                 @NotBlank String cidade, @NotBlank String telefone,
                 @NotBlank String cep, @NotNull Pais pais,
                 Estado estado) {
    this.email = email;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.documento = documento;
    this.endereco = endereco;
    this.complemento = complemento;
    this.cidade = cidade;
    this.telefone = telefone;
    this.cep = cep;
    this.pais = pais;
    this.estado = estado;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getNome() {
    return nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public String getDocumento() {
    return documento;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getCep() {
    return cep;
  }

  public Pais getPais() {
    return pais;
  }

  public Estado getEstado() {
    return estado;
  }
}
