# Batalha Naval

## Regras

- Cada jogador possui um tabuleiro
- No primeiro tabuleiro, cada jogador distribui, em seu próprio papel, as suas armas, pintando os quadrados correspondentes
- É obrigatório que seja deixado ao menos uma posição vazia separando duas armas
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
  - meuJogo: BatalhaNaval
  - jogoDoAdversário: BatalhaNaval
- Métodos:
  - atirar
  - verificarSeAcertou
  - registrarTiro

### BatalhaNaval
- Atributos:
  - tabuleiro: char[8][8]
- Métodos:
  - adicionarArmas
  - imprimirTabuleiro
