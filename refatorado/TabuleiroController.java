//1-Controller: A interface TabuleiroController é um controlador que define o contrato para manipulação do tabuleiro.

//2-Creator: A classe Tabuleiro é responsável por criar e gerenciar as informações do tabuleiro.

//3-High Cohesion: O código apresenta alta coesão, pois cada classe
// ou interface tem uma única responsabilidade e os métodos estão bem organizados de acordo com suas responsabilidades dentro do código. 

package refatorado;

public interface TabuleiroController {
  public abstract void setSimboloArma(char simboloArma);

  public abstract void adicionarArmas(char simboloArma);

  public abstract boolean verificarSeAcertouArma(int linha, int coluna);

  public abstract boolean verificarSePosicaoNaoTemArma(int linha, int coluna);

  public abstract boolean verificarSeColunasEstaoVazias(int linha, int colunaInicial, int tamanho);
}
