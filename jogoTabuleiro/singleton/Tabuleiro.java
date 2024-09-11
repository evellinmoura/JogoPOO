package jogoTabuleiro.singleton;

import java.util.ArrayList;
import jogoTabuleiro.pastaCasa.*;
import jogoTabuleiro.pastaJogador.Jogador;

public class Tabuleiro {
    private static Tabuleiro instancia;
    private final ArrayList<Jogador> jogadores;
    private final ArrayList<Casa> casas;
    private Tabuleiro() {
        jogadores = new ArrayList<>();
        casas = new ArrayList<>();
    }

    public static Tabuleiro getInstancia() {
        if (instancia == null) {
            instancia = new Tabuleiro();
        }
        return instancia;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    public void adicionarCasa(Casa casa) {
        casas.add(casa);
    }

    public void moverJogador(Jogador jogador, int casasMovidas) {
        jogador.mover(casasMovidas);
        jogador.incrementarJogada();
        if (jogador.getPosicao() < casas.size()) {
            casas.get(jogador.getPosicao()).aplicarRegra(jogador);
        }
    }

    public void moverJogadorDebug(Jogador jogador, int novaPosicao) {
        jogador.mover(novaPosicao - jogador.getPosicao());
        jogador.incrementarJogada();
        if (jogador.getPosicao() < casas.size()) {
            casas.get(jogador.getPosicao()).aplicarRegra(jogador);
        }
    }

    public Jogador getJogadorMaisAtrasado() {
        return jogadores.stream().min((j1, j2) -> Integer.compare(j1.getPosicao(), j2.getPosicao())).orElse(null);
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public int getNumeroCasas() {
        return casas.size();
    }

    public void mostrarEstado() {
        System.out.println("\nEstado do tabuleiro:");

        // Mostrar o tabuleiro graficamente no terminal
        for (int i = 0; i < casas.size(); i++) {
            StringBuilder linha = new StringBuilder("Casa " + i + " (");

            // Mostrar o tipo de casa
            if (casas.get(i) instanceof CasaSimples) {
                linha.append("Simples");
            } else if (casas.get(i) instanceof CasaPrisao) {
                linha.append("Prisao");
            } else if (casas.get(i) instanceof CasaSorte) {
                linha.append("Sorte");
            } else if (casas.get(i) instanceof CasaSurpresa) {
                linha.append("Surpresa");
            } else if (casas.get(i) instanceof CasaAzar) {
                linha.append("Azar");
            } else if (casas.get(i) instanceof CasaReversa) {
                linha.append("Reversa");
            } else if (casas.get(i) instanceof CasaJogaDeNovo) {
                linha.append("JogaDeNovo");
            } else if (casas.get(i) instanceof CasaTroca) {
                linha.append("Troca");
            }

            linha.append("): ");

            // Mostrar os jogadores na casa
            for (Jogador jogador : jogadores) {
                if (jogador.getPosicao() == i) {
                    linha.append("[").append(jogador.getCor().charAt(0)).append("] "); // Mostra a cor inicial do jogador
                } else {
                    linha.append("[ ] "); // Casa vazia
                }
            }
            System.out.println(linha.toString());
        }
        System.out.println("---------------------------------------------------");
    }

    public void mostrarResultadoFinal() {
        System.out.println("\nResultado final do jogo:");
        for (Jogador jogador : jogadores) {
            System.out.println("Jogador " + jogador.getCor() + " terminou na casa " + jogador.getPosicao()
                + " com " + jogador.getMoedas() + " moedas e fez " + jogador.getJogadas() + " jogadas.");
        }
        System.out.println("---------------------------------------------------");
    }
    public Casa getCasaAtual(int posicao) {
        // Verifica se a posição é válida
        if (posicao < 0 || posicao >= casas.size()) {
            throw new IllegalArgumentException("Posição fora dos limites do tabuleiro");
        }
        // Retorna a casa correspondente à posição
        return casas.get(posicao);
    }


}
