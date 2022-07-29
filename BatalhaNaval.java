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

  public void adicionaNovaArma(String tipo, int quantidade, char simbolo) {
    Scanner teclado = new Scanner(System.in);
    for (int i = 0; i < quantidade; i++) {
      System.out.println("\n" + (i + 1) + "˚ " + tipo);
      System.out.println("linha: ");
      int linha = teclado.nextInt();
      System.out.println("coluna: ");
      int coluna = teclado.nextInt();

      if (linha <= 7 && coluna <= 7 && tabuleiro[linha][coluna] == Character.MIN_VALUE) {
        tabuleiro[linha][coluna] = simbolo;

      } else {
        System.out.println("Erro ao adicionar arma na posição");
        i -= 1;
      }
    }
  }

  public void adicionarArmas() {
    System.out.println("Digite a posição das suas armas");
    adicionaNovaArma("Submarino", 3, 's');
    adicionaNovaArma("Cruzador", 2, 'c');
    adicionaNovaArma("Porta-aviões", 1, 'p');
    imprimirTabuleiro();
  }

  public void imprimirTabuleiro() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*- Tabuleiro -*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8");
    System.out.println("\t----------------------------------------------------------");

    for (int linha = 0; linha < tabuleiro.length; linha++) {
      System.out.print(linha + 1);
      for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
        System.out.print("\t" + tabuleiro[linha][coluna]);
      }
      System.out.println();
    }
  }
}
