package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Oculos extends JogadorDecorator {

    public Oculos(Jogador jogador) {
        super(jogador);
    }

    @Override
    public void adicionarMoedas(int qtd) {
        if (jogadorDecorado instanceof Moleton) {
            jogadorDecorado.adicionarMoedas(qtd + 6); // Óculos + Moleton + Boné = 7 moedas extras
        } else {
            jogadorDecorado.adicionarMoedas(qtd); // Sem moleton e boné, sem bônus
        }
    }

    @Override
    public int jogarDados() {
        return jogadorDecorado.jogarDados(); // Delegar jogarDados ao jogador original
    }
}
