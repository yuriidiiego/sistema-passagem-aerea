package br.com.fiveacademy.projeto.service;

import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;
import static br.com.fiveacademy.projeto.util.ServiceUtils.pulaDuasLinhas;
import static br.com.fiveacademy.projeto.util.ServiceUtils.pulaLinha;
import static br.com.fiveacademy.projeto.view.Menu.menuInicialReserva;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import br.com.fiveacademy.projeto.model.Log;
import br.com.fiveacademy.projeto.model.Usuario;
import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class UsuarioServiceImpl {
  private static Console console = System.console();
  private static List<Usuario> listaDeUsuarios = new LinkedList<>();
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RED = "\u001B[31m";
  private static final String ANSI_RESET = "\u001B[0m";

  public static Log cadastro() {
    limparTela();
    Usuario usuario = new Usuario();
    usuario.setId(UUID.randomUUID());
    String nome = console.readLine("Digite seu nome: ");
    usuario.setNome(nome);
    limparTela();
    String cpf = console.readLine("Digite seu CPF: ");
    usuario.setCpf(cpf);
    limparTela();
    String senha = console.readLine("Digite sua senha: ");
    usuario.setSenha(senha);
    usuario.setLogado(false);
    limparTela();

    adicionaNaLista(usuario);
    limparTela();

    return retornaLog();
  }

  public static void listarUsuarios() {
    limparTela();
    if (usuariosIsEmpty()) {
      console.printf(ANSI_RED + "Nenhum usuário cadastrado!\n" + ANSI_RESET);
      pulaLinha();
    } else {
      lista();
      pulaDuasLinhas();
    }
  }

  public static void login() throws IOException {
    limparTela();
    String cpf = console.readLine("Digite seu CPF: ");
    limparTela();
    String senha = console.readLine("Digite sua senha: ");
    limparTela();
    percorreListaELoga(cpf, senha);
    limparTela();
    console.printf(ANSI_RED + "CPF ou senha inválidos!\n\n" + ANSI_RESET);
  }

  public static void logout() {
    if (usuarioLogado()) {
      deslogar();
      limparTela();
      console.printf(
        ANSI_GREEN + "Logout realizado com sucesso!\n" + ANSI_RESET
      );
    } else {
      limparTela();
      console.printf(ANSI_RED + "Você não está logado!\n\n" + ANSI_RESET);
    }
  }

  private static void deslogar() {
    listaDeUsuarios.forEach(usuario -> usuario.setLogado(false));
  }

  private static boolean usuariosIsEmpty() {
    return listaDeUsuarios.isEmpty();
  }

  private static void percorreListaELoga(String cpf, String senha)
    throws IOException {
    for (Usuario usuario : listaDeUsuarios) {
      verificaELoga(cpf, senha, usuario);
      usuario.setLogado(true);
    }
  }

  private static Log retornaLog() {
    return new Log.Builder()
      .setAcao(
        console.printf(
          ANSI_GREEN + "Usuário cadastrado com sucesso!\n" + ANSI_RESET
        )
      )
      .setTimeStamp(
        console.printf(
          ANSI_GREEN +
          now().format(ofPattern("dd/MM/yyyy HH:mm:ss \n\n")) +
          ANSI_RESET
        )
      )
      .build();
  }

  private static void lista() {
    listaDeUsuarios.forEach(
      usuario -> console.printf(ANSI_GREEN + usuario.toString() + ANSI_RESET)
    );
  }

  private static void verificaELoga(String cpf, String senha, Usuario usuario)
    throws IOException {
    if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
      usuario.setLogado(true);
      limparTela();
      console.printf(
        ANSI_GREEN + "Login realizado com sucesso!\n\n" + ANSI_RESET
      );
      menuInicialReserva();
    }
  }

  private static void adicionaNaLista(Usuario usuario) {
    listaDeUsuarios.add(usuario);
  }

  private static boolean usuarioLogado() {
    return listaDeUsuarios.stream().anyMatch(Usuario::isLogado);
  }
}
