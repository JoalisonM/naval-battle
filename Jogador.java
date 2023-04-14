import java.util.Scanner;

public class Jogador {
  private String nome;
  private int acertos;
  private BatalhaNaval meuJogo;
  private char[][] jogoDoAdversario; // criador: o Jogador está sendo responsável por criar o jogoDoAdversário

  public Jogador(String nome, BatalhaNaval meuJogo) {
    this.nome = nome;
    this.acertos = 0;
    this.meuJogo = meuJogo;
    this.jogoDoAdversario = new char[8][8];
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

  public char[][] getJogoDoAdversario() {
    return jogoDoAdversario;
  }

  public void setJogoDoAdversario(char[][] jogoDoAdversario) {
    this.jogoDoAdversario = jogoDoAdversario;
  }

  public int getAcertos() {
    return acertos;
  }

  public void setAcertos(int acertos) {
    this.acertos = acertos;
  }

  // High Cohesion: A classe Jogador tem a responsabilidade de controlar as
  // jogadas de um jogador em um jogo de batalha naval. Assim, devemos manter
  // apenas os métodos relacionados a essa responsabilidade na classe Jogador.
  // Para isso, podemos mover o método adicionarArmas() para a classe
  // BatalhaNaval.
  public void adicionarArmas() {
    this.meuJogo.adicionarArmas();
  }

  // Controlador (Controller): O padrão Controlador (ou Controller) diz que uma
  // classe deve ser
  // responsável por coordenar ações de outras classes. No código fornecido, a
  // classe Jogador coordena
  // a ação de atirar e registrar tiros. Isso não é uma boa prática, pois a classe
  // Jogador já tem a
  // responsabilidade de representar um jogador
  public void atirar(Jogador jogadorAdversario) {
    int i = 0;
    while (i < 2) {
      if (this.acertos == 12) {
        break;
      }

      System.out.printf("\n[%s] acertou [%d/12]\n", nome, acertos);
      System.out.printf("Digite a posição que você vai atirar [%s]\n", nome);
      Scanner teclado = new Scanner(System.in);
      System.out.print("Digite a linha: ");
      int linha = teclado.nextInt();
      System.out.print("Digite a coluna: ");
      int coluna = teclado.nextInt();

      if (linha <= 7 && coluna <= 7) {
        boolean verificarSeAcertou = jogadorAdversario.verificarSeAcertou(linha, coluna);

        registrarTiro(linha, coluna, verificarSeAcertou);
        i++;
      } else {
        System.out.println("Erro ao atirar, tente novamente!");
        i--;
      }
    }
  }

  public boolean verificarSeAcertou(int linha, int coluna) {
    if (meuJogo.tabuleiro[linha][coluna] != Character.MIN_VALUE) {
      return true;
    } else {
      return false;
    }
  }

  public void registrarTiro(int linha, int coluna, boolean verificarSeAcertou) {
    if (this.jogoDoAdversario[linha][coluna] == Character.MIN_VALUE) {
      if (verificarSeAcertou) {
        this.jogoDoAdversario[linha][coluna] = 'O';
        System.out.println("Parabéns,você acertou na arma!\n");
        setAcertos(this.acertos + 1);
      } else {
        this.jogoDoAdversario[linha][coluna] = 'X';
        System.out.println("Tente na próxima rodada,você atirou na água.\n");
      }
    } else {
      System.out.println("Você já acertou um tiro nessa posição.\n");
    }

    this.imprimirTabuleiro();
  }

  public void imprimirTabuleiro() {
    System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*- Tabuleiro -*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
    System.out.println("\t0 \t1 \t2 \t3 \t4 \t5 \t6 \t7");
    System.out.println("\t----------------------------------------------------------");

    for (int linha = 0; linha < this.jogoDoAdversario.length; linha++) {
      System.out.print(linha);
      for (int coluna = 0; coluna < this.jogoDoAdversario[linha].length; coluna++) {
        System.out.print("\t" + this.jogoDoAdversario[linha][coluna]);
      }
      System.out.println();
    }
  }
}