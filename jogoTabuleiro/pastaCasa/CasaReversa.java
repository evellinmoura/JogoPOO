package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.singleton.Tabuleiro;

public class CasaReversa extends Casa {
    public CasaReversa(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        Tabuleiro tabuleiro = Tabuleiro.getInstancia();
        Jogador jogadorMaisAtras = tabuleiro.getJogadorMaisAtrasado();

        if (!jogador.equals(jogadorMaisAtras)) {
            int posicaoTemp = jogador.getPosicao();
            jogador.mover(jogadorMaisAtras.getPosicao() - jogador.getPosicao());
            jogadorMaisAtras.mover(posicaoTemp - jogadorMaisAtras.getPosicao());

            System.out.println("Jogador " + jogador.getCor() + " trocou de lugar com " + jogadorMaisAtras.getCor() + ".");
        } else {
            System.out.println("Jogador " + jogador.getCor() + " é o último e não se moveu.");
        }
    }
}
