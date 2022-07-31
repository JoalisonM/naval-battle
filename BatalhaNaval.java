import java.util.Scanner;

public class BatalhaNaval {
  public static final int lenght = 0;
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

  public void adicionaNovaArma(String tipo, char simbolo, int quantidade, int tamanho) {
    Scanner teclado = new Scanner(System.in);
    for (int i = 0; i < quantidade; i++) {
      for (int j = 0; j < tamanho; j++) {
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        System.out.println(tipo + " " + (i + 1) + "/" + quantidade + " " + " - tamanho: " + tamanho);
        System.out.println("\n" + (j + 1) + "/" + tamanho + " parte da arma");
        System.out.print("linha: ");
        int linha = teclado.nextInt();
        System.out.print("coluna: ");
        int coluna = teclado.nextInt();

        if (linha <= 7 && coluna <= 7 && tabuleiro[linha][coluna] == Character.MIN_VALUE) {
          tabuleiro[linha][coluna] = simbolo;

        } else {
          System.out.println("Erro ao adicionar arma na posição");
          j -= 1;
        }
      }
    }
  }

  public void adicionarArmas() {
    System.out.println("Digite a posição das suas armas");
    adicionaNovaArma("Submarino", 's', 3, 1);
    adicionaNovaArma("Cruzador", 'c', 2, 2);
    adicionaNovaArma("Porta-aviões", 'p', 1, 5);
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
