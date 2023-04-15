// 1- a classa arma atende a alguns padrões de GRASP, como o Creator,a classe Arma possui um construtor que é responsável por criar objetos da classe. 
//Isso segue o padrão Criador, onde a responsabilidade de criar novos objetos é atribuída à própria classe.

//2- Information expert: A classe Arma possui métodos para obter e alterar as informações relacionadas às armas, como nome, símbolo, quantidade e tamanho.
//Seguindo o padrão Especialista em informação, onde a responsabilidade de manipular as informações é atribuída à própria classe que as possui.

//3-High cohesion:possui apenas atributos e métodos relacionados às informações e operações de uma arma. 
//Isso indica que a classe possui uma alta coesão, ou seja, seus membros estão intimamente relacionados e pertencem à mesma abstração.

//4-Low Coupling: a classe Arma não depende de outras classes para executar suas operações e armazenar suas informações.
// o que  indica que a classe é independente e pode ser modificada sem afetar outras partes do sistema.


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
