package jogoTabuleiro.pastaJogador;

public abstract class Jogador {
    private final String cor;
    private int posicao;
    private int moedas;
    private int jogadas;
    private boolean preso;
    private int rodadasPreso;
    private boolean temBone;
    private boolean temMoleton;
    private boolean temOculos;

    public Jogador(String cor) {
        this.cor = cor;
        this.posicao = 0;
        this.moedas = 0;
        this.jogadas = 0;
        this.preso = false;
        this.rodadasPreso = 0;
        this.temBone = false;
        this.temMoleton = false;
        this.temOculos = false;
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
            this.rodadasPreso = 2;
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
        return this.moedas >= 2;
    }

    // Métodos para controlar os itens
    public boolean temBone() {
        return temBone;
    }

    public void setBone(boolean temBone) {
        this.temBone = temBone;
    }

    public boolean temMoleton() {
        return temMoleton;
    }

    public void setMoleton(boolean temMoleton) {
        this.temMoleton = temMoleton;
    }

    public boolean temOculos() {
        return temOculos;
    }

    public void setOculos(boolean temOculos) {
        this.temOculos = temOculos;
    }
}
