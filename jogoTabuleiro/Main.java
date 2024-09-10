package jogoTabuleiro;

import java.util.Scanner;
import jogoTabuleiro.facade.Jogo;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Jogo jogo = new Jogo();

            System.out.println("Digite o número de casas do tabuleiro:");
            int numCasas = scanner.nextInt();

            System.out.println("Digite o número de jogadores (2-6):");
            int numJogadores = scanner.nextInt();

            jogo.configTabuleiro(numCasas);
            jogo.config(numJogadores);

            jogo.printTabuleiro();
            jogo.start();
        }
    }
}
