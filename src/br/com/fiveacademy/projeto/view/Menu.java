package br.com.fiveacademy.projeto.view;

import static br.com.fiveacademy.projeto.service.UsuarioService.cadastro;
import static br.com.fiveacademy.projeto.service.UsuarioService.listarUsuarios;
import static br.com.fiveacademy.projeto.service.UsuarioService.login;
import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;

import br.com.fiveacademy.projeto.service.RotaService;
import java.io.Console;
import java.io.IOException;

public class Menu {
  static Console console = System.console();

  public static void menuInicial() throws IOException {
    console.printf("==========================\n");
    console.printf("Sistema de reserva de voos\n");
    console.printf("==========================\n");
    console.printf("|1 - Login\n");
    console.printf("|2 - Cadastro\n");
    console.printf("|3 - Listar Usuarios\n");
    console.printf("|4 - Sair\n");

    console.printf("Digite a opção desejada: ");

    String opcao = console.readLine();

    switch (opcao) {
      case "1":
        login();
        menuInicial();
        break;
      case "2":
        limparTela();
        cadastro();
        menuInicial();
        break;
      case "3":
        limparTela();
        listarUsuarios();
        menuInicial();
        break;
      case "4":
        System.exit(0);
        break;
      default:
        limparTela();
        console.printf("Opção inválida!\n\n");
        menuInicial();
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
        RotaService.reservarVoo();
        menuInicialReserva();
        break;
      case "2":
        RotaService.cancelarReserva();
        menuInicialReserva();
        break;
      case "3":
        RotaService.visualizarMinhasReservas();
        menuInicialReserva();
        break;
      case "4":
        menuInicial();
        break;
      default:
        limparTela();
        console.printf("Opção inválida!\n\n");
        menuInicialReserva();
        break;
    }
  }
}
