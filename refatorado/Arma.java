package refatorado;

public class Arma {
  private String nome;
  private char simbolo;
  private int quantidade, tamanho;

  public Arma(String nome, char simbolo, int quantidade, int tamanho) {
    this.nome = nome;
    this.simbolo = simbolo;
    this.tamanho = tamanho;
    this.quantidade = quantidade;
  }

  public String getNome() {
    return nome;
  }

  public void SetNome(String nome) {
    this.nome = nome;
  }

  public char getSimbolo() {
    return simbolo;
  }

  public void SetSimbolo(char simbolo) {
    this.simbolo = simbolo;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void SetQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void SetTamanho(int tamanho) {
    this.tamanho = tamanho;
  }
}
