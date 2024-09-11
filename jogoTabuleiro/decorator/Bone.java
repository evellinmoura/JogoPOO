package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Bone extends JogadorDecorator {

    public Bone(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void adicionarMoedas(int qtd) {
        jogadorDecorado.adicionarMoedas(qtd + 1); // Ganha 1 moeda extra em casas simples
    }

    @Override
    public int jogarDados() {
        return jogadorDecorado.jogarDados(); // Delegar jogarDados ao jogador original
    }
}
