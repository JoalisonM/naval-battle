//1-Information expert: a classe Tabuleiro possui informações sobre o próprio tabuleiro e sobre as armas, 
//sendo responsável por adicionar as armas e verificar se uma posição tem uma arma ou não.

//2-Creator : a classe Tabuleiro cria instâncias da classe Arma ao definir o símbolo da arma.

//3-Low coupling: esta classe não depende diretamente de outras, pois cria instâncias da classe Arma e implementa a interface TabuleiroController.

package refatorado;

public class Tabuleiro implements TabuleiroController {
  private char[][] tabuleiro;

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

  public void adicionarArma(int linha, int colunaInicial, int tamanho, char simboloArma) {
    for (int coluna = colunaInicial; coluna <= colunaInicial + (tamanho - 1); coluna++) {
      tabuleiro[linha][coluna] = simboloArma;
    }
  }
}
