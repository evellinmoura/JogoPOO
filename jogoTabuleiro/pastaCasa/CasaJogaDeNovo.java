package jogoTabuleiro.pastaCasa;

import jogoTabuleiro.pastaJogador.Jogador;

public class CasaJogaDeNovo extends Casa {
    public CasaJogaDeNovo(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        System.out.println("Jogador " + jogador.getCor() + " ganhou o direito de jogar novamente!");
        int valorDados = jogador.jogarDados();
        jogador.mover(valorDados);
        System.out.println("Jogador " + jogador.getCor() + " avançou " + valorDados + " casas.");
    }
}
