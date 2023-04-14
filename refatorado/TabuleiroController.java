package refatorado;

public interface TabuleiroController {
  public abstract void setSimboloArma(char simboloArma);

  public abstract void adicionarArmas(char simboloArma);

  public abstract boolean verificarSeAcertouArma(int linha, int coluna);

  public abstract boolean verificarSePosicaoNaoTemArma(int linha, int coluna);

  public abstract boolean verificarSeColunasEstaoVazias(int linha, int colunaInicial, int tamanho);
}
