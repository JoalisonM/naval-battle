import java.util.Scanner;
import java.text.ParseException;

public class Main {
  private static Jogador cadastrarJogador(BatalhaNaval tabuleiro) throws ParseException {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Nome do jogador: ");
    String nome = teclado.nextLine();

    Jogador jogador = new Jogador(nome, tabuleiro);

    return jogador;
  }

  public static void main(String[] args) throws ParseException {
    BatalhaNaval tabuleiroJogador1 = new BatalhaNaval();
    BatalhaNaval tabuleiroJogador2 = new BatalhaNaval();

    System.out.println("Cadastro do primeiro jogador");
    Jogador jogador1 = cadastrarJogador(tabuleiroJogador1);
    System.out.println("\nCadastro do segundo jogador");
    Jogador jogador2 = cadastrarJogador(tabuleiroJogador2);

    RodadaDeTiros rodadaDeTiros = new RodadaDeTiros(jogador1, jogador2);

    System.out.println("Jogador 1 - Adicionar armas");
    jogador1.adicionarArmas();

    System.out.println("\n\nJogador 2 - Adicionar armas");
    jogador2.adicionarArmas();

    rodadaDeTiros.trocaDeTiros();
  }
}