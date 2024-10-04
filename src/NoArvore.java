public class NoArvore {
    private char letra;
    private NoArvore esquerda;
    private NoArvore direita;

    public NoArvore(char letra) {
        this(letra, null, null);
    }

    public NoArvore(char letra, NoArvore esquerda, NoArvore direita) {
        this.letra = letra;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public NoArvore getDireita() {
        return this.direita;
    }

    public NoArvore getEsquerda() {
        return this.esquerda;
    }

    public char getLetra() {
        return this.letra;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
}
