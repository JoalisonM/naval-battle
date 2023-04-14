// Controller: Uma classe controladora será criada para coordenar a execução do jogo

// Creator: Uma classe deve ser responsável por criar instâncias de outras classes.

// No código refatorado, a classe Controller é responsável por criar as instâncias de Jogador e RodadaDeTiros

// High Cohesion: Cada classe deve ser altamente coesa e ter uma única responsabilidade.

// No código refatorado, a classe Jogador é responsável por armazenar o nome e o número de acertos de um jogador e implementar o método atirar. A classe RodadaDeTiros é responsável por gerenciar a troca de tiros entre os jogadores. A classe Controller é responsável por coordenar a execução do jogo e exibir o resultado.

// Low Coupling: As classes devem ter baixo acoplamento e depender apenas do que é necessário para executar suas responsabilidades.

public class RodadaDeTiros {
  private Jogador primeiroJogador, segundoJogador;

  public RodadaDeTiros(Jogador primeiroJogador, Jogador segundoJogador) {
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