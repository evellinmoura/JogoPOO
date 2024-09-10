package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public class Bone extends JogadorDecorator {

    public Bone(Jogador jogador) {
        super(jogador);
    }

    public void aplicarItem() {
        System.out.println("Jogador " + jogadorDecorado.getCor() + " está usando boné e ganhará +1 moeda nas casas simples.");
    }

    @Override
    public void adicionarMoedas(int qtd) {
        jogadorDecorado.adicionarMoedas(qtd + 1); // Ganha 1 moeda extra em casas simples
    }

     @Override
    public int jogarDados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jogarDados'");
    }
}
