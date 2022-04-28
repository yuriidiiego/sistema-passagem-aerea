package br.com.fiveacademy.projeto.service;

import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import br.com.fiveacademy.projeto.model.Log;
import br.com.fiveacademy.projeto.model.Rota;
import br.com.fiveacademy.projeto.model.Usuario;
import java.io.Console;

public class RotaService {
  static Console console = System.console();
  static ListaDeRotas listaDeRotas = new ListaDeRotas();
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";
  static UsuarioService usuarioService = new UsuarioService();
  static Usuario usuario = new Usuario();
  static Rota rota = new Rota();

  // Lista os voos e adiciona ao usuario logado
  public static Log reservarVoo() {
    limparTela();
    listaDeRotas.rotas.forEach(rota -> console.printf(rota.toString()));
    console.printf("\n");
    console.printf("Digite o ID do voo que deseja reservar: ");
    int id = Integer.parseInt(console.readLine());
    rota = listaDeRotas.buscarRota(id);
    usuario.getRotas().add(rota);
    return new Log.Builder()
      .setAcao(
        console.printf(ANSI_GREEN + "Voo reservado com sucesso!\n" + ANSI_RESET)
      )
      .setValor(
        console.printf(
          ANSI_GREEN + "Valor:" + rota.getPreco() + "\n" + ANSI_RESET
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

  public static void visualizarMinhasReservas() {
    limparTela();
    if (usuario.getRotas().isEmpty()) {
      console.printf("Nenhuma reserva realizada!\n");
      console.writer().println();
    } else {
      usuario
        .getRotas()
        .forEach(
          rota -> console.printf(ANSI_GREEN + rota.toString() + ANSI_RESET)
        );
      console.writer().println();
    }
  }

  public static void cancelarReserva() {
    if (usuario.getRotas().isEmpty()) {
      console.printf("Nenhuma reserva realizada!\n");
      console.writer().println();
    } else {
      limparTela();
      usuario.getRotas().forEach(rota -> console.printf(rota.toString()));
      console.printf("\n");
      console.printf("Digite o ID do voo que deseja cancelar: ");
      int id = Integer.parseInt(console.readLine());
      rota = listaDeRotas.buscarRota(id);
      usuario.getRotas().remove(rota);
      console.printf(
        ANSI_GREEN + "Reserva cancelada com sucesso!\n" + ANSI_RESET
      );
      console.writer().println();
    }
  }
}
