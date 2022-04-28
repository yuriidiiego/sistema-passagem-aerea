package br.com.fiveacademy.projeto.service;

import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;
import static br.com.fiveacademy.projeto.view.Menu.menuInicialReserva;
import static java.lang.String.format;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import br.com.fiveacademy.projeto.model.Log;
import br.com.fiveacademy.projeto.model.Usuario;
import java.io.Console;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class UsuarioService {
  static Console console = System.console();
  static List<Usuario> listaDeUsuarios = new LinkedList<>();
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";

  public static Log cadastro() throws IOException {
    Usuario usuario = new Usuario();
    usuario.setId(UUID.randomUUID());
    console.printf("Digite o nome: ");
    String nome = console.readLine();
    usuario.setNome(nome);
    limparTela();
    console.printf("Digite o CPF: ");
    String cpf = console.readLine();
    usuario.setCpf(cpf);
    limparTela();
    console.printf("Digite a senha: ");
    String senha = console.readLine();
    usuario.setSenha(senha);
    limparTela();

    listaDeUsuarios.add(usuario);
    limparTela();

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

  public static void listarUsuarios() {
    if (listaDeUsuarios.isEmpty()) {
      console.printf("Nenhum usuário cadastrado!\n");
      console.writer().println();
    } else {
      listaDeUsuarios.forEach(usuario -> console.printf(usuario.toString()));
      console.writer().println();
    }
  }

  public static void login() throws IOException {
    limparTela();
    console.printf("Digite o CPF: ");
    String cpf = console.readLine();
    console.printf("Digite a senha: ");
    String senha = console.readLine();
    for (Usuario usuario : listaDeUsuarios) {
      if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
        usuario.setLogado(true);
        limparTela();
        console.printf("Login realizado com sucesso!\n\n");
        menuInicialReserva();
      }
    }
    limparTela();
    console.printf("CPF ou senha inválidos\n");
  }

  public static String usuarioLogado() {
    String nome = "";
    for (Usuario usuario : listaDeUsuarios) {
      if (usuario.isLogado()) {
        nome = usuario.getNome();
      }
    }
    return nome;
  }
}
