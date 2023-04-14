package refatorado;

public class Jogo {
  private Jogador primeiroJogador, segundoJogador;

  public Jogo(Jogador primeiroJogador, Jogador segundoJogador) {
    this.primeiroJogador = primeiroJogador;
    this.segundoJogador = segundoJogador;
  }

  public Jogador getPrimeiroJogador() {
    return primeiroJogador;
  }

  public void setPrimeiroJogador(Jogador primeiroJogador) {
    this.primeiroJogador = primeiroJogador;
  }

  public Jogador getSegundoJogador() {
    return segundoJogador;
  }

  public void setSegundoJogador(Jogador segundoJogador) {
    this.segundoJogador = segundoJogador;
  }

  public void trocaDeTiros() {
    while (true) {
      if (this.segundoJogador.getAcertos() < 12) {
        this.primeiroJogador.atirar(this.segundoJogador);
      }

      if (this.primeiroJogador.getAcertos() < 12) {
        this.segundoJogador.atirar(this.primeiroJogador);
      }

      if (this.primeiroJogador.getAcertos() == 12) {
        System.out.printf("Fim da partida! Parabéns %s você ganhou!\n", this.primeiroJogador.getNome());
        break;
      }

      if (this.segundoJogador.getAcertos() == 12) {
        System.out.printf("Fim da partida! Parabéns %s você ganhou!\n", this.segundoJogador.getNome());
        break;
      }
    }
  }
}