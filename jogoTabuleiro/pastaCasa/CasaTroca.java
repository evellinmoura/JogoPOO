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
        Scanner scanner = new Scanner(System.in);  // Removido o try-with-resources

        if (jogador.getMoedas() < 1) {
            System.out.println("Jogador " + jogador.getCor() + " não tem moedas suficientes para comprar itens.");
            return; // Passa para o próximo jogador
        }

        System.out.println("Jogador " + jogador.getCor() + " caiu na Casa Troca!");

        if (!jogador.temBone()) {
            System.out.println("Você pode comprar o Boné por 1 moeda (+1 moeda em casa simples).");
            System.out.println("Deseja comprar o Boné? (1 - Sim, 2 - Não)");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            if (escolha == 1) {
                jogador.removerMoedas(1);
                jogador.setBone(true);
                System.out.println("Jogador " + jogador.getCor() + " comprou o Boné.");
                jogador = new Bone(jogador); // Aplica o bone
            }
        } else if (!jogador.temMoleton()) {
            System.out.println("Você pode comprar o Moleton por 1 moeda (+3 moedas com Boné em casa simples).");
            System.out.println("Deseja comprar o Moleton? (1 - Sim, 2 - Não)");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            if (escolha == 1) {
                jogador.removerMoedas(1);
                jogador.setMoleton(true);
                System.out.println("Jogador " + jogador.getCor() + " comprou o Moleton.");
                jogador = new Moleton(jogador); // Aplica o moleton
            }
        } else if (!jogador.temOculos()) {
            System.out.println("Você pode comprar o Óculos Escuros por 1 moeda (+7 moedas com Boné e Moleton em casa simples).");
            System.out.println("Deseja comprar o Óculos Escuros? (1 - Sim, 2 - Não)");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha
            if (escolha == 1) {
                jogador.removerMoedas(1);
                jogador.setOculos(true);
                System.out.println("Jogador " + jogador.getCor() + " comprou o Óculos Escuros.");
                jogador = new Oculos(jogador); // Aplica o oculos escuro
            }
        } else {
            System.out.println("Jogador " + jogador.getCor() + " já tem todos os itens.");
        }
    }
}
