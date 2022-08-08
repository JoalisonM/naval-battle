# Batalha Naval

## Regras

- Cada jogador possui um tabuleiro
- No primeiro tabuleiro, cada jogador distribui, em seu próprio papel, as suas armas, pintando os quadrados correspondentes
- É utilizado um tabuleiro menor, de dimensão 8x8
- Cada jogador pode disparar 2 tiros por rodada
- Os tipos de armas disponíveis são apenas três: submarinos, cruzadores e porta-aviões.

| Tipo de Arma | Representação | Quantidade |
| :----------: | :-----------: | :--------: |
|  Submarino   |       s       |     3      |
|   Cruzador   |       c       |     2      |
| Porta-aviões |       p       |     1      |

## Classes

### Jogador
- Atributos:
  - nome: String
  - acertos: int
  - meuJogo: BatalhaNaval
  - jogoDoAdversário: char[8][8]
- Métodos:
  - atirar
  - verificarSeAcertou
  - registrarTiro
  - imprimirTabuleiro

### BatalhaNaval
- Atributos:
  - tabuleiro: char[8][8]
- Métodos:
  - adicionarArmas
  - imprimirTabuleiro

## RodadaDeTiros
  - Atributos
    - primeiro jogador
    - segundo jogador
  - Métodos
    - trocaDeTiros
