package refatorado;

import java.util.Scanner;
import java.text.ParseException;

public class BatalhaNaval {
  private static Jogador cadastrarJogador(Tabuleiro tabuleiro) throws ParseException {
    Scanner teclado = new Scanner(System.in);

    System.out.print("Nome do jogador: ");
    String nome = teclado.nextLine();

    Jogador jogador = new Jogador(nome, tabuleiro);

    return jogador;
  }

  public static void main(String[] args) throws ParseException {
    Tabuleiro tabuleiroJogador1 = new Tabuleiro();
    Tabuleiro tabuleiroJogador2 = new Tabuleiro();

    System.out.println("Cadastro do primeiro jogador");
    Jogador joalison = cadastrarJogador(tabuleiroJogador1);
    System.out.println("\nCadastro do segundo jogador");
    Jogador euridyce = cadastrarJogador(tabuleiroJogador2);

    Jogo jogo = new Jogo(joalison, euridyce);

    System.out.println("Jogador 1 - Adicionar armas");
    joalison.adicionarArmasTabuleiro();

    System.out.println("\n\nJogador 2 - Adicionar armas");
    euridyce.adicionarArmasTabuleiro();

    jogo.trocaDeTiros();
  }
}
