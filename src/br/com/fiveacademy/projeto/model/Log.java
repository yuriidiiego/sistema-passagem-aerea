package br.com.fiveacademy.projeto.model;

import java.io.Console;

public class Log {

  public Log(Builder builder) {}

  private String timeStamp;
  private Usuario usuario;
  private String acao;
  private String valor;

  public static class Builder {
    private Console timeStamp;
    private Console acao;
    private Console valor;

    public Builder setTimeStamp(Console timeStamp) {
      this.timeStamp = timeStamp;
      return this;
    }

    public Builder setAcao(Console acao) {
      this.acao = acao;
      return this;
    }

    public Builder setValor(Console valor) {
      this.valor = valor;
      return this;
    }

    public Log build() {
      return new Log(this);
    }
  }

  @Override
  public String toString() {
    return (
      "Log{" +
      "timeStamp='" +
      timeStamp +
      '\'' +
      ", usuario=" +
      usuario +
      ", acao='" +
      acao +
      '\'' +
      ", valor='" +
      valor +
      '\'' +
      '}'
    );
  }
}
