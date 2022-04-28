package br.com.fiveacademy.projeto.model;

import br.com.fiveacademy.projeto.view.Menu;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Usuario {
  private UUID id;
  private String nome;
  private String cpf;
  private String senha;
  private boolean logado;
  private List<Rota> rotas = new LinkedList<>();

  public Usuario() {}

  public Usuario(
    UUID id,
    String nome,
    String cpf,
    String senha,
    boolean logado
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) throws IOException {
    if (nome.length() < 3) {
      System.out.println("Nome deve conter no mínimo 3 caracteres!");
    }
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) throws IOException {
    if (!cpf.matches("[0-9]+")) {
      System.out.println("CPF deve conter apenas números!");
      Menu.menuInicial();
    }
    if (cpf.length() != 11) {
      System.out.println("CPF deve conter 11 dígitos!");
      Menu.menuInicial();
    }
    this.cpf = cpf;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isLogado() {
    return logado;
  }

  public void setLogado(boolean logado) {
    this.logado = logado;
  }

  public List<Rota> getRotas() {
    return rotas;
  }

  public void setRotas(List<Rota> rotas) {
    this.rotas = rotas;
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
      "id: " +
      id +
      "\n" +
      "nome: " +
      nome +
      "\n" +
      "cpf: " +
      cpf +
      "\n" +
      "senha: " +
      senha +
      "\n" +
      "logado: " +
      logado +
      "\n"
    );
  }
}
