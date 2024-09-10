package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Oculos extends JogadorDecorator {

    public Oculos(Jogador jogador) {
        super(jogador);
    }

    public void aplicarItem() {
        System.out.println("Jogador " + jogadorDecorado.getCor() + " está usando óculos escuros e ganhará +7 moedas nas casas simples.");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jogarDados'");
    }
}
