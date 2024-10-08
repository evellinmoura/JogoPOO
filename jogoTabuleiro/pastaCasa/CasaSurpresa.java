package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.*;

import java.util.Random;

public class CasaSurpresa extends Casa {
    private Random random;

    public CasaSurpresa(int numero) {
        super(numero);
        this.random = new Random();
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        int escolha = random.nextInt(3); // 0 = Normal, 1 = Sortudo, 2 = Azarado

        switch (escolha) {
            case 0:
                jogador = new Normal(jogador.getCor());
                System.out.println("Jogador " + jogador.getCor() + " virou Normal.");
                break;
            case 1:
                jogador = new Sortudo(jogador.getCor());
                System.out.println("Jogador " + jogador.getCor() + " virou Sortudo.");
                break;
            case 2:
                jogador = new Azarado(jogador.getCor());
                System.out.println("Jogador " + jogador.getCor() + " virou Azarado.");
                break;
        }
    }
}
