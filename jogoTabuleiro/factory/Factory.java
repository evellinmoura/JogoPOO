package jogoTabuleiro.factory;

import jogoTabuleiro.pastaCasa.*;
import jogoTabuleiro.pastaJogador.*;

public class Factory {

    public static Jogador criarJogador(String tipo, String cor) {
        switch (tipo.toLowerCase()) {
            case "normal" -> {
                return new Normal(cor);
            }
            case "sortudo" -> {
                return new Sortudo(cor);
            }
            case "azarado" -> {
                return new Azarado(cor);
            }
            default -> throw new IllegalArgumentException("Tipo de jogador inválido.");
        }
    }

    public static Casa criarCasa(String tipo, int numero) {
        System.out.println("Criando casa do tipo: " + tipo); 
        switch (tipo.toLowerCase()) {
            case "simples" -> {
                return new CasaSimples(numero);
            }
            case "sorte" -> {
                return new CasaSorte(numero);
            }
            case "prisao" -> {
                return new CasaPrisao(numero);
            }
            case "azar" -> {
                return new CasaAzar(numero);
            }
            case "reversa" -> {
                return new CasaReversa(numero);
            }
            case "jogadadenovo" -> { // Ajuste para lidar com o nome em minúsculas
                return new CasaJogaDeNovo(numero);
            }
            case "troca" -> {
                return new CasaTroca(numero);
            }
            case "surpresa" -> {
                return new CasaSurpresa(numero);
            }
            default -> throw new IllegalArgumentException("Tipo de casa inválido: " + tipo);
        }
    }
}