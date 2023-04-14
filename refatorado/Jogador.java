package refatorado;

import java.util.Scanner;

public class Jogador {
  private String nome;
  private int acertos;
  private Tabuleiro tabuleiro;

  public Jogador(String nome, Tabuleiro tabuleiro) {
    this.nome = nome;
    this.acertos = 0;
    this.tabuleiro = tabuleiro;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getAcertos() {
    return acertos;
  }

  public void setAcertos(int acertos) {
    this.acertos = acertos;
  }

  public Tabuleiro getMeuJogo() {
    return tabuleiro;
  }

  public void setMeuJogo(Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public void adicionarArmasTabuleiro() {
    tabuleiro.adicionarArmas('s');
    tabuleiro.adicionarArmas('c');
    tabuleiro.adicionarArmas('p');
  }

  public void atirar(Jogador JogadorAdversario) {
    int i = 0;
    while (i < 2) {
      if (this.acertos == 12) {
        break;
      }

      System.out.printf("\n[%s] acertou [%d/12]\n", nome, acertos);
      System.out.printf("Digite a posição que você vai atirar [%s]\n", nome);
      Scanner teclado = new Scanner(System.in);
      System.out.print("Digite a linha: ");
      int linha = teclado.nextInt();
      System.out.print("Digite a coluna: ");
      int coluna = teclado.nextInt();

      if (linha <= 7 && coluna <= 7) {
        boolean verificarSeAcertou = JogadorAdversario.tabuleiro.verificarSeAcertouArma(linha, coluna);

        registrarTiro(linha, coluna, verificarSeAcertou, JogadorAdversario.tabuleiro.getTabuleiro());
        i++;
      } else {
        System.out.println("Erro ao atirar, tente novamente!");
        i--;
      }
    }
  }

  public void registrarTiro(int linha, int coluna, boolean verificarSeAcertou, char[][] tabuleiroAdversario) {
    if (tabuleiroAdversario[linha][coluna] == 'O') {
      System.out.println("Você já acertou um tiro nessa posição.\n");
    }

    if (verificarSeAcertou && tabuleiroAdversario[linha][coluna] != 'O') {
      tabuleiroAdversario[linha][coluna] = 'O';
      System.out.println("Parabéns,você acertou na arma!\n");
      setAcertos(this.acertos + 1);
    } else {
      tabuleiroAdversario[linha][coluna] = 'X';
      System.out.println("Tente na próxima rodada,você atirou na água.\n");
    }
  }
}
