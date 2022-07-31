public class Main {
  public static void main(String[] args) {
    BatalhaNaval tabuleiroJogador1 = new BatalhaNaval();
    BatalhaNaval tabuleiroJogador2 = new BatalhaNaval();

    Jogador jogador1 = new Jogador("Euridyce", tabuleiroJogador1);
    Jogador jogador2 = new Jogador("Joalison", tabuleiroJogador2);

    System.out.println("Jogador 1 - Adicionar armas");
    jogador1.adicionarArmas();
    
    System.out.println("\n\nJogador 2 - Adicionar armas");
    jogador2.adicionarArmas();

    jogador1.trocaDeTiros(jogador2);
  }
}