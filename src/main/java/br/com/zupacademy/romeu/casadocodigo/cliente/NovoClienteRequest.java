package br.com.zupacademy.romeu.casadocodigo.cliente;

import br.com.zupacademy.romeu.casadocodigo.compartilhado.excecoes.EstadoValidationException;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes.CPFOuCNPJ;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes.ValorUnico;
import br.com.zupacademy.romeu.casadocodigo.compartilhado.validacoes.VerifyIfExists;
import br.com.zupacademy.romeu.casadocodigo.estado.Estado;
import br.com.zupacademy.romeu.casadocodigo.estado.EstadoRepository;
import br.com.zupacademy.romeu.casadocodigo.pais.Pais;
import br.com.zupacademy.romeu.casadocodigo.pais.PaisRepository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class NovoClienteRequest {


  @NotBlank
  @Email
  @ValorUnico(campo = "email", tabela = Cliente.class)
  private String email;

  @NotBlank
  private String nome;

  @NotBlank
  private String sobrenome;

  @NotBlank
  @CPFOuCNPJ
  @ValorUnico(campo = "documento", tabela = Cliente.class, removeStrings = true)
  private String documento; //cpf ou CNPJ

  @NotBlank
  private String endereco;

  @NotBlank
  private String complemento;

  @NotBlank
  private String cidade;

  @NotBlank
  private String telefone;

  @NotBlank
  private String cep;

  @NotNull
  @VerifyIfExists(campo = "id", tabela = Pais.class)
  private Long paisId;

  private Long estadoId;

  /**
   * @deprecated para uso do hibernate
   */
  @Deprecated
  public NovoClienteRequest() {}

  public Cliente toModel(PaisRepository paisRepository, EstadoRepository estadoRepository) {
    Optional<Pais> optPais = paisRepository.findById(this.paisId);
    Pais pais = optPais.get();

    List<Optional<Estado>> listaDeEstadoByPaisId = estadoRepository.findByPaisId(this.paisId);

    /* Se há estados para aquele país e não foi enviado um estado, lança exceção */
    if (!listaDeEstadoByPaisId.isEmpty() && this.estadoId == null) {
      throw new EstadoValidationException("Deve ser informado um Estado para o País selecionado");
    }
    /* Se NÃO há estados para aquele país e não foi enviado um estado, segue com a criação do cliente */
    else if (listaDeEstadoByPaisId.isEmpty() && this.estadoId == null) {
      return new Cliente(email, nome, sobrenome, removeStrings(documento), endereco, complemento,
              cidade, removeStrings(telefone), removeStrings(cep), pais, null);
    }

    Optional<Estado> optEstado = estadoRepository.findById(this.estadoId);
    Estado estado = optEstado.get();

    if (!estado.verificaSePertenceAoPais(pais))
      throw new EstadoValidationException("O Estado informado não pertence ao País informado");

    return new Cliente(email, nome, sobrenome, removeStrings(documento), endereco, complemento,
            cidade, removeStrings(telefone), removeStrings(cep), pais, estado);
  }

  public String removeStrings(@NotNull String informacao) {
    return informacao.replaceAll("[^0-9]", "");
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

  public Long getPaisId() {
    return paisId;
  }

  public Long getEstadoId() {
    return estadoId;
  }
}
