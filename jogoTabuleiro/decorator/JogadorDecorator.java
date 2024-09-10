package jogoTabuleiro.decorator;

import jogoTabuleiro.pastaJogador.Jogador;

public abstract class JogadorDecorator extends Jogador {
    protected Jogador jogadorDecorado;

    public JogadorDecorator(Jogador jogador) {
        super(jogador.getCor());
        this.jogadorDecorado = jogador;
    }

    @Override
    public void mover(int casas) {
        jogadorDecorado.mover(casas);
    }

    @Override
    public int getPosicao() {
        return jogadorDecorado.getPosicao();
    }

    @Override
    public int getMoedas() {
        return jogadorDecorado.getMoedas();
    }

    @Override
    public void adicionarMoedas(int qtd) {
        jogadorDecorado.adicionarMoedas(qtd);
    }

    @Override
    public void incrementarJogada() {
        jogadorDecorado.incrementarJogada();
    }
}
