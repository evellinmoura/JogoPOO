package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;

public class CasaSimples extends Casa {
    public CasaSimples(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        jogador.adicionarMoedas(1);
        System.out.println("Jogador " + jogador.getCor() + " ganhou 1 moeda.");
    }
}
