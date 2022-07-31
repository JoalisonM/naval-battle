import java.util.Scanner;

public class Jogador {
  private String nome;
  private int acertos;
  private char[][] tabuleiro;
  private BatalhaNaval meuJogo, jogoDoAdversario;

  public Jogador(String nome, BatalhaNaval meuJogo, BatalhaNaval jogoDoAdversario) {
    this.nome = nome;
    this.acertos = 0;
    this.meuJogo = meuJogo;
    this.tabuleiro = new char[8][8];
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

  public char[][] getTabuleiro() {
    return tabuleiro;
  }

  public void setTabuleiro(char[][] tabuleiro) {
    this.tabuleiro = tabuleiro;
  }

  public int getAcertos() {
    return acertos;
  }

  public void setAcertos(int acertos) {
    this.acertos = acertos;
  }

  public void adicionarArmas() {
    this.meuJogo.adicionarArmas();
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
      this.tabuleiro[linha][coluna] = 'O';
      System.out.println("Parabéns,você acertou na arma!\n");
      this.acertos++;
    } else {
      this.tabuleiro[linha][coluna] = 'X';
      System.out.println("Tente na próxima rodada,você atirou na água.\n");
    }

    this.imprimirTabuleiro();
  }

  public void trocaDeTiros() {
  }

  public void ganhador() {
  }

  public void imprimirTabuleiro() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*- Tabuleiro -*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    System.out.println("\t1 \t2 \t3 \t4 \t5 \t6 \t7 \t8");
    System.out.println("\t----------------------------------------------------------");

    for (int linha = 0; linha < this.tabuleiro.length; linha++) {
      System.out.print(linha + 1);
      for (int coluna = 0; coluna < this.tabuleiro[linha].length; coluna++) {
        System.out.print("\t" + this.tabuleiro[linha][coluna]);
      }
      System.out.println();
    }
  }
}