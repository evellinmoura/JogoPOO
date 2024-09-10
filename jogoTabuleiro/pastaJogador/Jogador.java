package jogoTabuleiro.pastaJogador;

public abstract class Jogador {
    private final String cor;
    private int posicao;
    private int moedas;
    private int jogadas;
    private boolean preso;
    private int rodadasPreso; // Contador de rodadas que o jogador está preso

    public Jogador(String cor) {
        this.cor = cor;
        this.posicao = 0;
        this.moedas = 0;
        this.jogadas = 0;
        this.preso = false;
        this.rodadasPreso = 0;
    }

    public abstract int jogarDados();

    public void mover(int casas) {
        this.posicao += casas;
    }

    public void adicionarMoedas(int qtd) {
        this.moedas += qtd;
    }

    public void removerMoedas(int qtd) {
        this.moedas = Math.max(this.moedas - qtd, 0);
    }

    public int getPosicao() {
        return this.posicao;
    }

    public int getMoedas() {
        return this.moedas;
    }

    public void incrementarJogada() {
        this.jogadas++;
    }

    public String getCor() {
        return this.cor;
    }

    public boolean isPreso() {
        return this.preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
        if (preso) {
            this.rodadasPreso = 2; // Jogador fica preso por 2 rodadas
        }
    }

    public int getJogadas() {
        return jogadas;
    }

    public int getRodadasPreso() {
        return rodadasPreso;
    }

    public void decrementarRodadasPreso() {
        if (rodadasPreso > 0) {
            rodadasPreso--;
            if (rodadasPreso == 0) {
                preso = false;
            }
        }
    }

    public boolean podePagarParaSair() {
        return this.moedas >= 2; // Verifica se o jogador pode pagar 2 moedas para sair da prisão
    }
}
