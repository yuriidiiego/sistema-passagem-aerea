package br.com.fiveacademy.projeto.model;

public class Rota {
  private Long id;
  private String origem;
  private String destino;
  private String horario;
  private String data;
  private String preco;
  private Usuario usuario;

  public Rota() {}

  public Rota(
    Long id,
    String origem,
    String destino,
    String horario,
    String data,
    String preco,
    Usuario usuario
  ) {
    this.id = id;
    this.origem = origem;
    this.destino = destino;
    this.horario = horario;
    this.data = data;
    this.preco = preco;
    this.usuario = usuario;
  }

  public Rota(
    Long id,
    String origem,
    String destino,
    String horario,
    String data,
    String preco
  ) {
    this.id = id;
    this.origem = origem;
    this.destino = destino;
    this.horario = horario;
    this.data = data;
    this.preco = preco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getHorario() {
    return horario;
  }

  public void setHorario(String horario) {
    this.horario = horario;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getPreco() {
    return preco;
  }

  public void setPreco(String preco) {
    this.preco = preco;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Rota other = (Rota) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    return true;
  }

  @Override
  public String toString() {
    return (
      id +
      " | " +
      "Origem: " +
      origem +
      " | " +
      "Destino: " +
      destino +
      " | " +
      "Horario: " +
      horario +
      " | " +
      "Data: " +
      data +
      " | " +
      "Preco: " +
      preco +
      "\n"
    );
  }
}
