package jogoTabuleiro.facade;

import java.util.Scanner;
import jogoTabuleiro.factory.Factory;
import jogoTabuleiro.pastaJogador.Jogador;
import jogoTabuleiro.singleton.Tabuleiro;

public class Jogo {
    private final Tabuleiro tabuleiro;
    private final Scanner scanner;

    public Jogo() {
        this.tabuleiro = Tabuleiro.getInstancia();
        this.scanner = new Scanner(System.in);
    }

    public void configTabuleiro(int numCasas) {
        System.out.println("Configurando o tabuleiro com " + numCasas + " casas.");
        for (int i = 1; i <= numCasas; i++) {
            if (i == 13) {
                tabuleiro.adicionarCasa(Factory.criarCasa("surpresa", i));
            } else if (i == 10 || i == 25 || i == 38) {
                tabuleiro.adicionarCasa(Factory.criarCasa("prisao", i));
            } else if (i == 11 || i == 28) {
                tabuleiro.adicionarCasa(Factory.criarCasa("reversa", i)); // Casas Reversas
            } else if (i == 7 || i == 21) {
                tabuleiro.adicionarCasa(Factory.criarCasa("jogadaDeNovo", i)); // Casas de JogaDeNovo
            } else if (i == 9 || i == 33) {
                tabuleiro.adicionarCasa(Factory.criarCasa("troca", i)); // Casas de Troca
            } else if (i % 5 == 0) {
                tabuleiro.adicionarCasa(Factory.criarCasa("sorte", i)); // Casas de Sorte (ex.: 5, 15, 20, etc.)
            } else {
                tabuleiro.adicionarCasa(Factory.criarCasa("simples", i)); // Casas Simples (restante)
            }
        }
    }
    

    public void config(int numJogadores) {
        System.out.println("Configurando " + numJogadores + " jogadores.");
        for (int i = 0; i < numJogadores; i++) {
            System.out.println("Digite a cor do jogador " + (i + 1) + ":");
            String cor = scanner.nextLine();

            System.out.println("Escolha o tipo do jogador (normal, sortudo, azarado):");
            String tipo = scanner.nextLine();

            tabuleiro.adicionarJogador(Factory.criarJogador(tipo, cor));
        }
    }

    public void printTabuleiro() {
        tabuleiro.mostrarEstado();
    }

    public void start() {
        System.out.println("Iniciando o jogo!");

        boolean jogoAtivo = true;
        while (jogoAtivo) {
            for (Jogador jogador : tabuleiro.getJogadores()) {
                System.out.println("\nVez do jogador " + jogador.getCor() + " com " + jogador.getMoedas() + " moedas.");
                
                if (jogador.isPreso()) {
                    if (jogador.getRodadasPreso() > 0) {
                        System.out.println("Jogador " + jogador.getCor() + " está preso por mais " + jogador.getRodadasPreso() + " rodada(s).");

                        // Verificar se o jogador quer pagar para sair da prisão
                        if (jogador.podePagarParaSair()) {
                            System.out.println("Digite '1' para pagar 2 moedas e sair da prisão, ou '2' para esperar:");
                            int escolha = scanner.nextInt();
                            if (escolha == 1) {
                                jogador.removerMoedas(2);
                                jogador.decrementarRodadasPreso();
                                System.out.println("Jogador " + jogador.getCor() + " pagou 2 moedas e está livre.");
                            } else {
                                jogador.decrementarRodadasPreso();
                                continue;
                            }
                        } else {
                            System.out.println("Jogador " + jogador.getCor() + " não tem moedas suficientes para sair da prisão.");
                            jogador.decrementarRodadasPreso();
                            continue;
                        }
                    }
                }

                System.out.println("Digite '1' para rolar os dados ou '2' para entrar no modo Debug:");
                int escolha = scanner.nextInt();

                if (escolha == 1) {
                    int valorDados = jogador.jogarDados();
                    System.out.println("O jogador " + jogador.getCor() + " rolou: " + valorDados);
                    tabuleiro.moverJogador(jogador, valorDados);
                } else if (escolha == 2) {
                    System.out.println("Modo Debug: para qual casa o jogador deve ir?");
                    int novaPosicao = scanner.nextInt();
                    tabuleiro.moverJogadorDebug(jogador, novaPosicao);
                }

                // Exibe o estado do tabuleiro após a jogada
                tabuleiro.mostrarEstado();

                if (jogador.getPosicao() >= tabuleiro.getNumeroCasas()) {
                    System.out.println("O jogador " + jogador.getCor() + " venceu o jogo!");
                    jogoAtivo = false;
                    break;
                }
            }
        }

        finalizarJogo();
    }

    private void finalizarJogo() {
        System.out.println("Jogo finalizado!");

        // Exibe o resultado final com as jogadas e moedas de cada jogador
        tabuleiro.mostrarResultadoFinal();
    }
}
