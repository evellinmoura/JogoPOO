package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.pastaJogador.Azarado;

public class CasaSorte extends Casa {
    public CasaSorte(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        if (!(jogador instanceof Azarado)) {
            jogador.mover(3);
            System.out.println("Jogador " + jogador.getCor() + " avançou 3 casas!");
        } else {
            System.out.println("Jogador azarado não pode avançar.");
        }
    }
}
