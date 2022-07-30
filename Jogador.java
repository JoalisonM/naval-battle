import java.util.Scanner;

public class Jogador {
  private String nome;
  private BatalhaNaval meuJogo, jogoDoAdversario;

  public Jogador(String nome, BatalhaNaval meuJogo, BatalhaNaval jogoDoAdversario) {
    this.nome = nome;
    this.meuJogo = meuJogo;
    this.jogoDoAdversario = jogoDoAdversario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BatalhaNaval getMeuJogo() {
    return meuJogo;
  }

  public void setMeuJogo(BatalhaNaval meuJogo) {
    this.meuJogo = meuJogo;
  }

  public BatalhaNaval getJogoDoAdversario() {
    return jogoDoAdversario;
  }

  public void setJogoDoAdversario(BatalhaNaval jogoDoAdversario) {
    this.jogoDoAdversario = jogoDoAdversario;
  }

  public void atirar(Jogador jogadorAdversario) {
    for (int i = 0; i < 2; i++) {
      System.out.println("Digite a posição que você vai atirar");
      Scanner teclado = new Scanner(System.in);
      System.out.print("Digite a linha: ");
      int linha = teclado.nextInt();
      System.out.print("\nDigite a coluna: ");
      int coluna = teclado.nextInt();

      boolean verificarSeAcertou = jogadorAdversario.verificarSeAcertou(linha, coluna);

      jogadorAdversario.registrarTiro(linha, coluna, verificarSeAcertou);
    }
  }

  public boolean verificarSeAcertou(int linha, int coluna) {
    if (jogoDoAdversario.tabuleiro[linha][coluna] != Character.MIN_VALUE) {
      return true;
    } else {
      return false;
    }
  }

  public void registrarTiro(int linha, int coluna, boolean verificarSeAcertou) {
    if (verificarSeAcertou) {
      jogoDoAdversario.tabuleiro[linha][coluna] = 'O';
    } else {
      jogoDoAdversario.tabuleiro[linha][coluna] = 'X';
    }

    jogoDoAdversario.imprimirTabuleiro();
  }
}