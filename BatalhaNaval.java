import java.util.Scanner;

public class BatalhaNaval {
  public char[][] tabuleiro;

  public BatalhaNaval() {
    this.tabuleiro = new char[8][8];
  }

  public char[][] getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(char[][] tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public void adicionarArmas(int linha, int coluna) {
  }

  public void imprimirTabuleiro() {
    System.out.println("-*-*-*-*-*-*-*- Tabuleiro -*-*-*-*-*-*-*-");
    for (int linha = 0; linha < tabuleiro.length; linha++) {
      System.out.println((linha + 1) + "  ");
      for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
        // if (coluna + 1)
      }
    }
  }
}
