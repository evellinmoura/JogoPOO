package jogoTabuleiro.pastaCasa;

import java.util.Scanner;
import jogoTabuleiro.decorator.*;
import jogoTabuleiro.pastaJogador.Jogador;

public class CasaTroca extends Casa {
    public CasaTroca(int numero) {
        super(numero);
    }

    @Override
    public void aplicarRegra(Jogador jogador) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Jogador " + jogador.getCor() + " caiu na Casa Troca! Escolha um item:");
            System.out.println("1 - Boné (+1 moeda em casa simples)");
            System.out.println("2 - Moleton (+3 moedas com boné)");
            System.out.println("3 - Óculos Escuros (+7 moedas com boné e moleton)");

            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1 -> {
                    jogador = new Bone(jogador);
                    System.out.println("Jogador " + jogador.getCor() + " escolheu Boné.");
                }
                case 2 -> {
                    jogador = new Moleton(jogador);
                    System.out.println("Jogador " + jogador.getCor() + " escolheu Moleton.");
                }
                case 3 -> {
                    jogador = new Oculos(jogador);
                    System.out.println("Jogador " + jogador.getCor() + " escolheu Óculos Escuros.");
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
