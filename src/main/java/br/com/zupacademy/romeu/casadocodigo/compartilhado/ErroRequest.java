package br.com.zupacademy.romeu.casadocodigo.compartilhado;

public class ErroRequest {
  private String campo;
  private String erro;

  public ErroRequest(String campo, String erro) {
    this.campo = campo;
    this.erro = erro;
  }

  public String getCampo() {
    return campo;
  }

  public String getErro() {
    return erro;
  }
}
