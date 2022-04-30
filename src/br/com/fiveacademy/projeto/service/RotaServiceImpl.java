package br.com.fiveacademy.projeto.service;

import static br.com.fiveacademy.projeto.util.ServiceUtils.limparTela;
import static br.com.fiveacademy.projeto.util.ServiceUtils.pulaLinha;
import static java.lang.Integer.parseInt;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;

import br.com.fiveacademy.projeto.model.Log;
import br.com.fiveacademy.projeto.model.Rota;
import br.com.fiveacademy.projeto.model.Usuario;
import br.com.fiveacademy.projeto.util.ListaDeRotas;
import java.io.Console;

public class RotaServiceImpl {
  private static Console console = System.console();
  static ListaDeRotas listaDeRotas = new ListaDeRotas();
  private static final String ANSI_GREEN = "\u001B[32m";
  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\u001B[31m";
  private static Usuario usuario = new Usuario();
  private static Rota rota = new Rota();

  public static Log cadastraReservas() {
    limparTela();
    listaRotas();
    pulaLinha();
    int id = parseInt(console.readLine("Digite o ID da rota: "));
    buscaRotaPorId(id);
    if (usuario.getRotas().contains(rota)) {
      limparTela();
      console.printf(
        ANSI_RED + "Você já possui reserva para essa rota!\n" + ANSI_RESET
      );
      pulaLinha();
      return null;
    }
    adicionaRotaAoUsuario();
    limparTela();
    return messageLog();
  }

  public static void visualizaReservas() {
    limparTela();
    if (reservasIsEmpty()) {
      console.printf(ANSI_RED + "Nenhuma reserva realizada!\n" + ANSI_RESET);
      pulaLinha();
    } else {
      listaMinhasReservas();
      pulaLinha();
    }
  }

  public static void cancelaReservas() {
    limparTela();
    if (reservasIsEmpty()) {
      console.printf(ANSI_RED + "Reserva não encontrada!\n" + ANSI_RESET);
      pulaLinha();
    } else {
      limparTela();
      listaMinhasReservas();
      pulaLinha();
      int id = parseInt(console.readLine("Digite o ID da reserva: "));
      buscaRotaPorId(id);
      removeRota();
      limparTela();
      console.printf(
        ANSI_GREEN + "Reserva cancelada com sucesso!\n" + ANSI_RESET
      );
      pulaLinha();
    }
  }

  private static boolean reservasIsEmpty() {
    return usuario.getRotas().isEmpty();
  }

  private static void removeRota() {
    usuario.getRotas().remove(rota);
  }

  private static void buscaRotaPorId(int id) {
    rota = listaDeRotas.buscarRota(id);
  }

  private static void listaMinhasReservas() {
    usuario
      .getRotas()
      .forEach(
        rota -> console.printf(ANSI_GREEN + rota.toString() + ANSI_RESET)
      );
  }

  private static void listaRotas() {
    listaDeRotas.rotas.forEach(
      rota -> console.printf(ANSI_GREEN + rota.toString() + ANSI_RESET)
    );
  }

  private static void adicionaRotaAoUsuario() {
    usuario.getRotas().add(rota);
  }

  private static Log messageLog() {
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
}
