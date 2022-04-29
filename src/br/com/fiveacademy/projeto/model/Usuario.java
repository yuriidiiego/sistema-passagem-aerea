package br.com.fiveacademy.projeto.model;

import static br.com.fiveacademy.projeto.util.ServiceUtils.digiteNovamente;
import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Usuario {
  private UUID id;
  private String nome;
  private String cpf;
  private String senha;
  private Boolean logado;
  private List<Rota> rotas = new LinkedList<>();
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_RESET = "\u001B[0m";

  public Usuario() {}

  public Usuario(
    UUID id,
    String nome,
    String cpf,
    String senha,
    Boolean logado
  ) {
    this.id = id;
    this.nome = nome;
    this.cpf = cpf;
    this.senha = senha;
    this.logado = logado;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public void setNome(String nome) {
    limparTela();
    while (!nome.matches("[a-zA-Z ]+")) {
      System.out.println(
        ANSI_RED + "Nome deve conter apenas letras!" + ANSI_RESET
      );
      nome = digiteNovamente();
      limparTela();
    }
    while (nome.length() < 3 || nome.length() > 50) {
      System.out.println(
        ANSI_RED + "Nome deve ter entre 3 e 50 caracteres!" + ANSI_RESET
      );
      nome = digiteNovamente();
      limparTela();
    }
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    limparTela();
    while (!cpf.matches("[0-9]+")) {
      System.out.println(
        ANSI_RED + "CPF deve conter apenas números! " + ANSI_RESET
      );
      cpf = digiteNovamente();
      limparTela();
    }
    while (cpf.length() != 11) {
      System.out.println(ANSI_RED + "CPF deve ter 11 caracteres!" + ANSI_RESET);
      cpf = digiteNovamente();
      limparTela();
    }
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public void setLogado(Boolean logado) {
    this.logado = logado;
  }

  public List<Rota> getRotas() {
    return rotas;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Usuario other = (Usuario) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  public String toString() {
    return (
      "ID: " +
      id +
      " | " +
      "Nome: " +
      nome +
      " | " +
      "CPF: " +
      cpf +
      " | " +
      "Senha: " +
      senha +
      " | " +
      "Logado: " +
      logado
    );
  }

  public Boolean isLogado() {
    return Boolean.TRUE.equals(logado);
  }
}
