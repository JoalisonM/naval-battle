package refatorado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class ArmaController {
  private Collection armasCriadas = new ArrayList();
  private Tabuleiro tabuleiro;

  public ArmaController(Tabuleiro tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public char[][] getTabuleiro() {
    return tabuleiro.getTabuleiro();
  }

  public void adicionarArmaNoTabuleiro(int linha, int colunaInicial, int tamanho, char simbolo) {
    tabuleiro.adicionarArma(linha, colunaInicial, tamanho, simbolo);
  }

  public boolean verificarSePosicaoEstaLivre(int linha, int coluna) {
    return tabuleiro.verificarSePosicaoNaoTemArma(linha, coluna);
  }

  public boolean verificarSeColunasEstaoVazias(int linha, int colunaInicial, int tamanho) {
    return tabuleiro.verificarSeColunasEstaoVazias(linha, colunaInicial, tamanho);
  }

  public boolean verificarTamanhoSuficienteDoTabuleiro(int colunaInicial, int tamanho) {
    return colunaInicial <= (8 - tamanho);
  }

  public void adicionarArma(Arma arma) {
    armasCriadas.add(arma);
  }

  public void adicionarArmasNoTabuleiro() {
    Iterator armas = armasCriadas.iterator();
    while (armas.hasNext()) {
      Arma arma = (Arma) armas.next();
      Scanner teclado = new Scanner(System.in);
      for (int i = 0; i < arma.getQuantidade(); i++) {
        System.out.println("\n=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=");
        System.out.println(
            arma.getNome() + " " + (i + 1) + "/" + arma.getQuantidade() + " " + " - tamanho: " + arma.getTamanho());
        System.out.print("linha: ");
        int linha = teclado.nextInt();
        System.out.print("coluna: ");
        int colunaInicial = teclado.nextInt();

        if (verificarTamanhoSuficienteDoTabuleiro(colunaInicial, arma.getTamanho())) {
          if (verificarSePosicaoEstaLivre(linha, colunaInicial)) {
            if (verificarSeColunasEstaoVazias(linha, colunaInicial, arma.getTamanho())) {
              adicionarArmaNoTabuleiro(linha, colunaInicial, arma.getTamanho(), arma.getSimbolo());
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
}