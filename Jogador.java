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
    System.out.println("Digite a posição que você vai atirar");
    Scanner teclado = new Scanner(System.in);
    System.out.print("Digite a linha: ");
    int linha = teclado.nextInt();
    System.out.print("\nDigite a coluna");
    int coluna = teclado.nextInt();

    jogadorAdversario.verificarSeAcertou(linha, coluna);

    jogadorAdversario.registrarTiro(linha, coluna, jogadorAdversario);
  }

  public void verificarSeAcertou(int linha, int coluna) {
    // if () {}
  }

  public void registrarTiro(int linha, int coluna, Jogador jogadorAdversario) {
  }
}