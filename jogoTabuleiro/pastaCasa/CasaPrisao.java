package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;

public class CasaPrisao extends Casa {
    public CasaPrisao(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        if (!jogador.isPreso()) {
            jogador.setPreso(true);
            System.out.println("Jogador " + jogador.getCor() + " foi preso! Ficará preso por 2 rodadas ou pode pagar 2 moedas para sair.");
        } else {
            System.out.println("Jogador " + jogador.getCor() + " ainda está preso.");
        }
    }
}
