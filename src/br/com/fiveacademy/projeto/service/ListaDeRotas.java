package br.com.fiveacademy.projeto.service;

import br.com.fiveacademy.projeto.model.Rota;
import java.util.ArrayList;
import java.util.List;

public class ListaDeRotas {
  public List<Rota> rotas = new ArrayList<>();

  public ListaDeRotas() {
    rotas.add(
      new Rota(
        1L,
        "São Paulo",
        "Rio de Janeiro",
        "12:00",
        "12/12/2020",
        "R$ 100,00"
      )
    );
    rotas.add(
      new Rota(
        2L,
        "Paraná",
        "Rio de Janeiro",
        "14:00",
        "10/12/2020",
        "R$ 300,00"
      )
    );
    rotas.add(
      new Rota(
        3L,
        "Tocantins",
        "Rio Grande do Sul",
        "16:00",
        "02/10/2020",
        "R$ 600,00"
      )
    );
    rotas.add(
      new Rota(4L, "Pará", "Amazonas", "8:00", "20/10/2020", "R$ 150,00")
    );
    rotas.add(
      new Rota(
        5L,
        "Mato Grosso",
        "Maranhão",
        "21:00",
        "12/12/2020",
        "R$ 1000,00"
      )
    );
  }

  public Rota buscarRota(int id) {
    for (Rota rota : rotas) {
      if (rota.getId() == id) {
        return rota;
      }
    }
    System.out.println("Rota não encontrada");
    return null;
  }
}
