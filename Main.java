public class Main {
  public static void main(String[] args) {
    BatalhaNaval tabuleiroJogador1 = new BatalhaNaval();
    BatalhaNaval tabuleiroJogador2 = new BatalhaNaval();

    tabuleiroJogador1.adicionarArmas();
    tabuleiroJogador2.adicionarArmas();

    Jogador jogador1 = new Jogador("Euridyce", tabuleiroJogador1, tabuleiroJogador2, null);
    Jogador jogador2 = new Jogador("Jooj", tabuleiroJogador2, tabuleiroJogador1, null);

    jogador1.atirar(jogador2);
  }
}