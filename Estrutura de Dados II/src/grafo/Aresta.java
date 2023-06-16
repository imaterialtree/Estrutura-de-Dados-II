package grafo;

public class Aresta {
    private int peso;
    private int cor;
    private Vertice inicio;
    private Vertice fim;

    public Aresta(int peso, Vertice inicio, Vertice fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
        cor = -1;
    }

    public Aresta(Vertice inicio, Vertice fim) {
        this.inicio = inicio;
        this.fim = fim;
        peso = 1;
        cor = -1;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public Vertice getInicio() {
        return inicio;
    }

    public void setInicio(Vertice inicio) {
        this.inicio = inicio;
    }

    public Vertice getFim() {
        return fim;
    }

    public void setFim(Vertice fim) {
        this.fim = fim;
    }

    @Override
    public String toString() {
        return String.format("%s -(%d)> %s",inicio, peso, fim);
    }
}
