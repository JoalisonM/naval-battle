public class Main {
  public static void main(String[] args) {
    BatalhaNaval tabuleiroJogador1 = new BatalhaNaval();
    BatalhaNaval tabuleiroJogador2 = new BatalhaNaval();

    Jogador euridyce = new Jogador("Euridyce", tabuleiroJogador1);
    Jogador joalison = new Jogador("Joalison", tabuleiroJogador2);

    RodadaDeTiros rodadaDeTiros = new RodadaDeTiros(euridyce, joalison);

    System.out.println("Jogador 1 - Adicionar armas");
    euridyce.adicionarArmas();

    System.out.println("\n\nJogador 2 - Adicionar armas");
    joalison.adicionarArmas();

    rodadaDeTiros.trocaDeTiros();
  }
}