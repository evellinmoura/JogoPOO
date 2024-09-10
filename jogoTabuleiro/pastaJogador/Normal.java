package jogoTabuleiro.pastaJogador;

import java.util.Random;

public class Normal extends Jogador {
    private final Random random;

    public Normal(String cor) {
        super(cor);
        this.random = new Random();
    }

    @Override
    public int jogarDados() {
        int dado1 = random.nextInt(6) + 1;
        int dado2 = random.nextInt(6) + 1;
        return dado1 + dado2;
    }
}
