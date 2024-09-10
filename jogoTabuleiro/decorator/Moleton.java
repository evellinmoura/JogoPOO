package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Moleton extends JogadorDecorator {

    public Moleton(Jogador jogador) {
        super(jogador);
    }

    public void aplicarItem() {
        System.out.println("Jogador " + jogadorDecorado.getCor() + " está usando moleton e ganhará +4 moedas nas casas simples.");
    }

    @Override
    public void adicionarMoedas(int qtd) {
        if (jogadorDecorado instanceof Bone) {
            jogadorDecorado.adicionarMoedas(qtd + 3); // Moleton + Boné = 4 moedas extras
        } else {
            jogadorDecorado.adicionarMoedas(qtd); // Sem boné, sem bônus
        }
    }

    @Override
    public int jogarDados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jogarDados'");
    }
}
