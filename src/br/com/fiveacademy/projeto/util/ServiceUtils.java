package br.com.fiveacademy.projeto.util;

import java.io.Console;

public class ServiceUtils {
  static Console console = System.console();

  public static void limparTela() {
    console.printf("\033[H\033[2J");
    console.flush();
  }

  public static String digiteNovamente() {
    return console.readLine("\nDigite novamente: ");
  }

  public static void pulaLinha() {
    console.writer().println();
  }

  public static void pulaDuasLinhas() {
    console.printf("\n\n");
  }
}
