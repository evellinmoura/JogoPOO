package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Oculos extends JogadorDecorator {

    public Oculos(Jogador jogador) {
        super(jogador);
    }

    public void aplicarItem() {
        System.out.println("Jogador " + jogadorDecorado.getCor() + " está usando óculos escuros e ganhará +6 moedas extras nas casas simples com o boné e moleton.");
    }

    @Override
    public void adicionarMoedas(int qtd) {
        if (jogadorDecorado instanceof Moleton) {
            jogadorDecorado.adicionarMoedas(qtd + 6); // Óculos + Moleton + Boné = 7 moedas extras
        } else {
            jogadorDecorado.adicionarMoedas(qtd); // Sem moleton e boné, sem bônus adicional
        }
    }

    @Override
    public int jogarDados() {
        return jogadorDecorado.jogarDados();
    }
}
