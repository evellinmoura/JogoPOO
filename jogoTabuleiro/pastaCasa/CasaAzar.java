package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.pastaJogador.Sortudo;

public class CasaAzar extends Casa {
    public CasaAzar(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        if (!(jogador instanceof Sortudo)) {
            jogador.removerMoedas(3); // Correção feita aqui
            System.out.println("Jogador " + jogador.getCor() + " perdeu 3 moedas.");
        } else {
            System.out.println("Jogador sortudo não perde moedas.");
        }
    }
}
