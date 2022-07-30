import java.util.Scanner;

public class Jogador {
  private String nome;
  private BatalhaNaval meuJogo, jogoDoAdversario;
  private char[][] tabuleiro;
  
  public Jogador(String nome, BatalhaNaval meuJogo, BatalhaNaval jogoDoAdversario, char[][] tabuleiro) {
    this.nome = nome;
    this.meuJogo = meuJogo;
    this.jogoDoAdversario = jogoDoAdversario;
    this.tabuleiro = new char[8][8];
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
  public char[][] getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(char[][] tabuleiro) {
    this.tabuleiro = tabuleiro;
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
    if (jogoDoAdversario.tabuleiro[linha][coluna] !=        Character.MIN_VALUE){
      return true;
    } else {
      return false;
    }
    
  }

  public void registrarTiro(int linha, int coluna, boolean verificarSeAcertou) {
      int contador=0;
      if (verificarSeAcertou) {
          contador++;
      tabuleiro[linha][coluna] = 'O';
      System.out.println("Parabéns,você acertou na arma!");
    } else {
      tabuleiro[linha][coluna] = 'X';
      System.out.println("Tente na próxima rodada,você atirou na água.");
    }

    jogoDoAdversario.imprimirTabuleiro();
  }
}