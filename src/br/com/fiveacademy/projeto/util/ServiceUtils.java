package br.com.fiveacademy.projeto.util;

import java.io.Console;

public class ServiceUtils {
  static Console console = System.console();

  public static void limparTela() {
    console.printf("\033[H\033[2J");
    console.flush();
  }

  public static void esperarTecla() {
    console.printf("\nPressione qualquer tecla para continuar...");
    console.readLine();
  }
}
