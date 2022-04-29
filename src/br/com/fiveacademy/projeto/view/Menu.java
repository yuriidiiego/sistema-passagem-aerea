package br.com.fiveacademy.projeto.view;

import static br.com.fiveacademy.projeto.service.RotaServiceImpl.cadastraReservas;
import static br.com.fiveacademy.projeto.service.RotaServiceImpl.cancelaReservas;
import static br.com.fiveacademy.projeto.service.RotaServiceImpl.visualizaReservas;
import static br.com.fiveacademy.projeto.service.UsuarioServiceImpl.cadastro;
import static br.com.fiveacademy.projeto.service.UsuarioServiceImpl.listarUsuarios;
import static br.com.fiveacademy.projeto.service.UsuarioServiceImpl.login;
import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;

import br.com.fiveacademy.projeto.service.UsuarioServiceImpl;
import java.io.Console;
import java.io.IOException;

public class Menu {
  private static Console console = System.console();
  public static final String RED_BRIGHT = "\033[0;91m";
  public static final String YELLOW_BRIGHT = "\033[0;93m";
  private static final String ANSI_BLUE = "\u001B[34m";
  private static final String ANSI_RESET = "\u001B[0m";

  public static void menuInicialUsuario() throws IOException {
    console.printf(
      RED_BRIGHT +
      "================================================================================\n" +
      ANSI_RESET
    );
    console.printf(
      YELLOW_BRIGHT +
      "S I S T E M A   D E   R E S E R V A   D E   P A S S A G E N S   D E   A V I Ã O \n" +
      ANSI_RESET
    );
    console.printf(
      ANSI_BLUE +
      "================================================================================\n" +
      ANSI_RESET
    );

    console.printf("1 - Login\n");
    console.printf("2 - Cadastro\n");
    console.printf("3 - Listar Usuarios\n");
    console.printf("4 - Logout\n");
    console.printf("5 - Sair\n");

    console.printf("Digite a opção desejada: ");

    String opcao = console.readLine();

    switch (opcao) {
      case "1":
        login();
        menuInicialUsuario();
        break;
      case "2":
        cadastro();
        menuInicialUsuario();
        break;
      case "3":
        listarUsuarios();
        menuInicialUsuario();
        break;
      case "4":
        UsuarioServiceImpl.logout();
        menuInicialUsuario();
        break;
      case "5":
        System.exit(0);
        break;
      default:
        limparTela();
        console.printf(RED_BRIGHT + "Opção inválida!\n\n" + ANSI_RESET);
        menuInicialUsuario();
        break;
    }
  }

  public static void menuInicialReserva() throws IOException {
    console.printf("1 - Reservar voo\n");
    console.printf("2 - Cancelar reserva\n");
    console.printf("3 - Listar minhas reservas\n");
    console.printf("4 - Voltar ao menu inicial\n");

    console.printf("Digite a opção desejada: ");

    String opcao = console.readLine();

    switch (opcao) {
      case "1":
        cadastraReservas();
        menuInicialReserva();
        break;
      case "2":
        cancelaReservas();
        menuInicialReserva();
        break;
      case "3":
        visualizaReservas();
        menuInicialReserva();
        break;
      case "4":
        limparTela();
        menuInicialUsuario();
        break;
      default:
        limparTela();
        console.printf("Opção inválida!\n\n");
        menuInicialReserva();
        break;
    }
  }
}
