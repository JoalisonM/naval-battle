//1-Creator: A classe BatalhaNaval cria objetos das classes Jogador, Tabuleiro e Jogo. 
//a responsabilidade de criar novos objetos é atribuída à própria classe.

//2-Controller: esta classe  é responsável por controlar a lógica do jogo, através da chamada de métodos de outras classes e da interação com o usuário através do console.
//o controller traz a responsabilidade de controlar a lógica atribuindo a uma classe separada, para evitar que a classe principal fique sobrecarregada.

//3- High cohesion:  possui apenas métodos relacionados à lógica do jogo, como cadastrar jogadores, adicionar armas ao tabuleiro e iniciar a troca de tiros. 

//4-Low Coupling: essa classe depende de outras classes para executar suas operações, como Jogador, Tabuleiro e Jogo, 
//mas essa dependência é gerenciada através da passagem de parâmetros e da chamada de métodos. 
//a classe é independente e pode ser modificada sem afetar outras partes do sistema.

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
