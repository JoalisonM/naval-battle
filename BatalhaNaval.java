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

  public boolean verificarSePosicaoNaoTemArma(int linha, int coluna) {
    if (linha <= 7 && coluna <= 7 && tabuleiro[linha][coluna] == Character.MIN_VALUE) {
      return true;
    } else
      return false;
  }

  public boolean verificarSeColunasEstaoVazias(int linha, int colunaInicial, int tamanho) {
    int todasPosicoesVazias = 0;
    for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
      if (verificarSePosicaoNaoTemArma(linha, coluna)) {
        todasPosicoesVazias += 1;
      }
    }

    if (todasPosicoesVazias == tamanho) {
      return true;
    } else {
      return false;
    }
  }

  public void adicionaNovaArma(String tipo, char simbolo, int quantidade, int tamanho) {
    Scanner teclado = new Scanner(System.in);
    for (int i = 0; i < quantidade; i++) {
      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println(tipo + " " + (i + 1) + "/" + quantidade + " " + " - tamanho: " + tamanho);
      System.out.print("linha: ");
      int linha = teclado.nextInt();
      System.out.print("coluna: ");
      int colunaInicial = teclado.nextInt();

      if (tipo.equals("Porta-aviões")) {
        if (colunaInicial <= 3) {
          if (verificarSePosicaoNaoTemArma(linha, colunaInicial)) {
            if (verificarSeColunasEstaoVazias(linha, colunaInicial, tamanho)) {
              for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
                tabuleiro[linha][coluna] = simbolo;
              }
            } else {
              System.out.println("Erro ao adicionar arma nas posições");
              i--;
            }
          } else {
            System.out.println("Erro ao adicionar, na primeira posição já há uma arma");
            i--;
          }
        } else {
          System.out.println("Erro ao adicionar porta aviões, tamanho insuficiente do tabuleiro.");
          i--;
        }
      } else if (tipo.equals("Cruzador")) {
        if (colunaInicial <= 6) {
          if (verificarSePosicaoNaoTemArma(linha, colunaInicial)) {
            if (verificarSeColunasEstaoVazias(linha, colunaInicial, tamanho)) {
              for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
                tabuleiro[linha][coluna] = simbolo;
              }
            } else {
              System.out.println("Erro ao adicionar arma nas posições");
              i--;
            }
          } else {
            System.out.println("Erro ao adicionar, na primeira posição já há uma arma");
            i--;
          }
        } else {
          System.out.println("Erro ao adicionar porta aviões, tamanho insuficiente do tabuleiro.");
          i--;
        }
      } else {
        if (verificarSePosicaoNaoTemArma(linha, colunaInicial)) {
          for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
            if (verificarSePosicaoNaoTemArma(linha, coluna)) {
              tabuleiro[linha][coluna] = simbolo;
            } else {
              System.out.println("Erro ao adicionar arma na posição");
              i--;
            }
          }
        } else {
          System.out.println("Na primeira posição já há uma arma");
          i--;
        }
      }
    }
  }

  public void adicionarArmas() {
    System.out.println("Digite a posição das suas armas");
    adicionaNovaArma("Submarino", 's', 3, 1);
    // adicionaNovaArma("Cruzador", 'c', 2, 2);
    // adicionaNovaArma("Porta-aviões", 'p', 1, 5);
    imprimirTabuleiro();
  }

  public void imprimirTabuleiro() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*- Tabuleiro -*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7");
    System.out.println("\t----------------------------------------------------------");

    for (int linha = 0; linha < tabuleiro.length; linha++) {
      System.out.print(linha);
      for (int coluna = 0; coluna < tabuleiro[linha].length; coluna++) {
        System.out.print("\t" + tabuleiro[linha][coluna]);
      }
      System.out.println();
    }
  }
}