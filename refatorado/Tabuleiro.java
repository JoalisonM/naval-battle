//1-Information expert: a classe Tabuleiro possui informações sobre o próprio tabuleiro e sobre as armas, 
//sendo responsável por adicionar as armas e verificar se uma posição tem uma arma ou não.

//2-Creator : a classe Tabuleiro cria instâncias da classe Arma ao definir o símbolo da arma.

//3-Low coupling: esta classe não depende diretamente de outras, pois cria instâncias da classe Arma e implementa a interface TabuleiroController.

package refatorado;

import java.util.Scanner;

public class Tabuleiro implements TabuleiroController {
  public static final int SUBMARINO = 's';
  public static final int CRUZADOR = 'c';
  public static final int PORTA_AVIOES = 'p';
  private char[][] tabuleiro;
  private Arma arma;

  public Tabuleiro() {
    this.tabuleiro = new char[8][8];
  }

  public char[][] getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(char[][] tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public boolean verificarSeAcertouArma(int linha, int coluna) {
    return (tabuleiro[linha][coluna] != Character.MIN_VALUE) ? true : false;
  }

  public boolean verificarSePosicaoNaoTemArma(int linha, int coluna) {
    return (linha <= 7 && coluna <= 7 && tabuleiro[linha][coluna] == Character.MIN_VALUE) ? true : false;
  }

  public boolean verificarSeColunasEstaoVazias(int linha, int colunaInicial, int tamanho) {
    int todasPosicoesVazias = 0;
    for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
      if (this.verificarSePosicaoNaoTemArma(linha, coluna)) {
        todasPosicoesVazias += 1;
      }
    }

    return (todasPosicoesVazias == tamanho) ? true : false;
  }

  public void setSimboloArma(char simboloArma) {
    switch (simboloArma) {
      case SUBMARINO:
        arma = new Arma("Submarino", 's', 3, 1);
        break;
      case CRUZADOR:
        arma = new Arma("Cruzador", 'c', 2, 2);
        break;
      case PORTA_AVIOES:
        arma = new Arma("Porta Aviões", 'p', 1, 5);
        break;
    }
  }

  public void adicionarArmas(char simboloArma) {
    setSimboloArma(simboloArma);

    Scanner teclado = new Scanner(System.in);
    for (int i = 0; i < arma.getQuantidade(); i++) {
      System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
      System.out.println(
          arma.getNome() + " " + (i + 1) + "/" + arma.getQuantidade() + " " + " - tamanho: " + arma.getTamanho());
      System.out.print("linha: ");
      int linha = teclado.nextInt();
      System.out.print("coluna: ");
      int colunaInicial = teclado.nextInt();

      if (colunaInicial <= (8 - arma.getTamanho())) {
        if (verificarSePosicaoNaoTemArma(linha, colunaInicial)) {
          if (verificarSeColunasEstaoVazias(linha, colunaInicial, arma.getTamanho())) {
            for (int coluna = colunaInicial; coluna <= colunaInicial + (arma.getTamanho() - 1); coluna++) {
              tabuleiro[linha][coluna] = arma.getSimbolo();
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
        System.out.println("Erro ao adicionar arma, tamanho insuficiente do tabuleiro.");
        i--;
      }
    }
  }
}
